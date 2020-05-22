public void keyReleased(KeyEvent e) {
    // resume the ability to modify our comboBoxEditorComponent's Document
    if (isTrigger(e))
        doNotChangeDocument = false;

    // keyPressed(e) has disabled the JComboBox's normal processing of the enter key
    // so now it is time to perform our own processing. We reattach all ActionListeners
    // and simulate exactly ONE ActionEvent in the JComboBox and then reenable Document changes.
    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
        updateFilter();

        // reregister all ActionListeners and then notify them due to the ENTER key

        // Note: We *must* check for a null ActionListener[]. The reason
        // is that it is possible to receive a keyReleased() callback
        // *without* a corresponding keyPressed() callback! It occurs
        // when focus is transferred away from the ComboBoxEditor and
        // then the ENTER key transfers focus back to the ComboBoxEditor.
        if (actionListeners != null) {
            registerAllActionListeners(comboBox, actionListeners);
            comboBox.actionPerformed(new ActionEvent(e.getSource(), e.getID(), null));
        }

        // null out our own reference to the ActionListeners
        actionListeners = null;

        // reenable Document changes once more
        doNotChangeDocument = false;
    }

    if (!isTableCellEditor)
        doNotTogglePopup = true;
}