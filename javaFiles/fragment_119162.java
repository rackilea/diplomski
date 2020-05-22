/**
 * updates the button states
 */
private void updateButtons() {
    boolean dirty = isDirty() && canSave();
    fApplyButton.setEnabled(dirty);
    fRevertButton.setEnabled(dirty);
}