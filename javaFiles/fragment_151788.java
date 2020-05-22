private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    this.jComboBox3.removeAllItems();
    String boxOneValue = jComboBox1.getSelectedItem().toString();
    for(int i = 0; i < jComboBox2.getItemCount(); i++) {
        jComboBox3.addItem(boxOneValue + jComboBox2.getItemAt(i));
    }
}