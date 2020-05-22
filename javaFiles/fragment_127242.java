public void focusGained(FocusEvent fe) {
    createUndoMananger();
}

public void focusLost(FocusEvent fe) {
    removeUndoMananger();
}