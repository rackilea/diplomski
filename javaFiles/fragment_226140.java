private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // Make sure input is a class variable and it will continue to grow                                         
    input.add(jTextField1.getText());
    input.add(jTextField2.getText());
    jTextArea4.setText(String.valueOf(input));      
}