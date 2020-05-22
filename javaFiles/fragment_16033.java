new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
    jButton2ActionPerformed(evt);
    Person value = (Person)jComboBox1.getSelectedItem();
    jTextField1.setText(value.getId());
}