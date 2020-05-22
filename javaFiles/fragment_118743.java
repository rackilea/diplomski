private UndoManager undoManager;

// In the constructor

undoManager = new UndoManager();
Document doc = textArea.getDocument();
doc.addUndoableEditListener(new UndoableEditListener() {
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {

        System.out.println("Add edit");
        undoManager.addEdit(e.getEdit());

    }
});

InputMap im = textArea.getInputMap(JComponent.WHEN_FOCUSED);
ActionMap am = textArea.getActionMap();

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

am.put("Undo", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        } catch (CannotUndoException exp) {
            exp.printStackTrace();
        }
    }
});
am.put("Redo", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (undoManager.canRedo()) {
                undoManager.redo();
            }
        } catch (CannotUndoException exp) {
            exp.printStackTrace();
        }
    }
});