/**
 * {@inheritDoc} <p>
 * Overridden to fix focus issues with editors. 
 * This method installs and updates the internal CellEditorRemover which
 * terminates ongoing edits if appropriate. Additionally, it
 * registers a CellEditorListener with the cell editor to grab the 
 * focus back to tree, if appropriate.
 * 
 * @see #updateEditorRemover()
 */
@Override
public void startEditingAtPath(TreePath path) {
    super.startEditingAtPath(path);
    if (isEditing()) {
        updateEditorListener();
        updateEditorRemover();
    }
}


/**
 * Hack to grab focus after editing.
 */
private void updateEditorListener() {
    if (editorListener == null) {
        editorListener = new CellEditorListener() {

            @Override
            public void editingCanceled(ChangeEvent e) {
                terminated(e);
            }

            /**
             * @param e
             */
            private void terminated(ChangeEvent e) {
                analyseFocus();
                ((CellEditor) e.getSource()).removeCellEditorListener(editorListener);
            }

            @Override
            public void editingStopped(ChangeEvent e) {
                terminated(e);
            }

        };
    }
    getCellEditor().addCellEditorListener(editorListener);

}

/**
 * This is called from cell editor listener if edit terminated.
 * Trying to analyse if we should grab the focus back to the
 * tree after. Brittle ... we assume we are the first to 
 * get the event, so we can analyse the hierarchy before the
 * editing component is removed.
 */
protected void analyseFocus() {
    if (isFocusOwnerDescending()) {
        requestFocusInWindow();
    }
}


/**
 * Returns a boolean to indicate if the current focus owner 
 * is descending from this table. 
 * Returns false if not editing, otherwise walks the focusOwner
 * hierarchy, taking popups into account. <p>
 * 
 * PENDING: copied from JXTable ... should be somewhere in a utility
 * class?
 * 
 * @return a boolean to indicate if the current focus
 *   owner is contained.
 */
private boolean isFocusOwnerDescending() {
    if (!isEditing()) return false;
    Component focusOwner = 
        KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
    // PENDING JW: special casing to not fall through ... really wanted?
    if (focusOwner == null) return false;
    if (SwingXUtilities.isDescendingFrom(focusOwner, this)) return true;
    // same with permanent focus owner
    Component permanent = 
        KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
    return SwingXUtilities.isDescendingFrom(permanent, this);
}



/**
 * Overridden to release the CellEditorRemover, if any.
 */
@Override
public void removeNotify() {
    if (editorRemover != null) {
        editorRemover.release();
        editorRemover = null;
    }
    super.removeNotify();
}

/**
 * Lazily creates and updates the internal CellEditorRemover.
 * 
 *
 */
private void updateEditorRemover() {
    if (editorRemover == null) {
        editorRemover = new CellEditorRemover();
    }
    editorRemover.updateKeyboardFocusManager();
}

/** This class tracks changes in the keyboard focus state. It is used
 * when the JXTree is editing to determine when to terminate the edit.
 * If focus switches to a component outside of the JXTree, but in the
 * same window, this will terminate editing. The exact terminate 
 * behaviour is controlled by the invokeStopEditing property.
 * 
 * @see javax.swing.JTree#setInvokesStopCellEditing(boolean)
 * 
 */
public class CellEditorRemover implements PropertyChangeListener {
    /** the focusManager this is listening to. */
    KeyboardFocusManager focusManager;

    public CellEditorRemover() {
        updateKeyboardFocusManager();
    }

    /**
     * Updates itself to listen to the current KeyboardFocusManager. 
     *
     */
    public void updateKeyboardFocusManager() {
        KeyboardFocusManager current = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        setKeyboardFocusManager(current);
    }

    /**
     * stops listening.
     *
     */
    public void release() {
        setKeyboardFocusManager(null);
    }

    /**
     * Sets the focusManager this is listening to. 
     * Unregisters/registers itself from/to the old/new manager, 
     * respectively. 
     * 
     * @param current the KeyboardFocusManager to listen too.
     */
    private void setKeyboardFocusManager(KeyboardFocusManager current) {
        if (focusManager == current)
            return;
        KeyboardFocusManager old = focusManager;
        if (old != null) {
            old.removePropertyChangeListener("permanentFocusOwner", this);
        }
        focusManager = current;
        if (focusManager != null) {
            focusManager.addPropertyChangeListener("permanentFocusOwner",
                    this);
        }

    }
    @Override
    public void propertyChange(PropertyChangeEvent ev) {
        if (!isEditing()) {
            return;
        }

        Component c = focusManager.getPermanentFocusOwner();
        JXTree tree = JXTree.this;
        while (c != null) {
            if (c instanceof JPopupMenu) {
                c = ((JPopupMenu) c).getInvoker();
            } else {

                if (c == tree) {
                    // focus remains inside the table
                    return;
                } else if ((c instanceof Window) ||
                        (c instanceof Applet && c.getParent() == null)) {
                    if (c == SwingUtilities.getRoot(tree)) {
                        if (tree.getInvokesStopCellEditing()) {
                            tree.stopEditing();
                        }
                        if (tree.isEditing()) {
                            tree.cancelEditing();
                        }
                    }
                    break;
                }
                c = c.getParent();
            }
        }
    }
}