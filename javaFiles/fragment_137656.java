DefaultTableModel model ;
  public MyJframe() {
         initComponents();
         model=new DefaultTableModel();
         jTable1.setModel(model);
         model.addColumn("DJID");
         model.addColumn("DID");
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try {
        // Code for inserting to database
        model.addRow(new Object[]{DaneshjooID,DarsID});
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
    }
}