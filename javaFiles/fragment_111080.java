private void jButtonClearActionPerfomed(java.awt.event.ActionEvent evt) {
    if(evt.getSource()==jButtonClear) {
        DefaultListModel listModel = (DefaultListModel) jList1.getModel();
        listModel.removeAllElements();
    }
}