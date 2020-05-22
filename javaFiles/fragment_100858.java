private void jButton1ActionPerformed(ActionEvent evt) {                                         
    String name = jTextField1.getText();

    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        if (((String)model.getValueAt(i, 0)).equals(name)) {
            model.removeRow(i);
            break;
        }
    }
}