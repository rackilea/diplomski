private void btnComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
 Form2 f2 = new Form2(comboOne.getSelectedItem().toString());       
 f2.setSize(250, 300);
 f2.setLocationRelativeTo(this);
 f2.setVisible(true);
}