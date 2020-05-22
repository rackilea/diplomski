public void keyPressed(KeyEvent e) {
    if (!isTableCellEditor)
        doNotTogglePopup = false;

    // this KeyHandler performs ALL processing of the ENTER key otherwise multiple
    // ActionEvents are fired to ActionListeners by the default JComboBox processing.
    // To control processing of the enter key, we set a flag to avoid changing the
    // editor's Document in any way, and also unregister the ActionListeners temporarily.
    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
        doNotChangeDocument = true;
        this.actionListeners = unregisterAllActionListeners(comboBox);
    }

    // make sure this backspace key does not modify our comboBoxEditorComponent's Document
    if (isTrigger(e))
        doNotChangeDocument = true;
}