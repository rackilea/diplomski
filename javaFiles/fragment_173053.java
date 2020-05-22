private int r;
private int c;
private String buffer;

private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {                                     
    jTextField2.requestFocus();
    buffer = jTextField1.getText();
    jTable1.getModel().setValueAt(jTextField1.getText(), r, c); 
}                                    

private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {                                 
    r = jTable1.getSelectedRow();
    c = jTable1.getSelectedColumn();
    jTable1.putClientProperty("terminateEditOnFocusLost", true);

    jTextField1.requestFocus();
}                                

private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {                                        
    buffer = (String)jTable1.getModel().getValueAt(r, c);
    jTextField1.setText(buffer);
    jLabel1.setText(buffer);   
}                                       

private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {                                        
    buffer = jTextField1.getText();
    jTable1.getModel().setValueAt(buffer, r, c);
    jTextField1.requestFocus();
}