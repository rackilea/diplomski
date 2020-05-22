private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Tname       =   name.getText(); // *** follow Java naming rules please
    String tName = name.getText();

    DefaultListModel model = (DefaultListModel) list.getModel();
    model.addElement(tName);
}