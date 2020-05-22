public class UndoManager extends CompoundEdit implements UndoableEditListener {
    ...
    public synchronized void redo() throws CannotRedoException {
        if (inProgress) {
            UndoableEdit edit = editToBeRedone();
            if (edit == null) {
                throw new CannotRedoException();
            }
            redoTo(edit);
        } else {
            super.redo();
        }
    }
    ...
    protected void redoTo(UndoableEdit edit) throws CannotRedoException {
        boolean done = false;
        while (!done) {
            UndoableEdit next = edits.elementAt(indexOfNextAdd++);
            next.redo(); // NPE here?
            done = next == edit;
        }
    }
    ...
}