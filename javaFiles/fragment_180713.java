public voi calculate(){
    int result;
    int num1 = (Integer.parseInt(jTextField2.getText()));
    int num2 = (Integer.parseInt(jTextField4.getText()));

    jTextField6.setText(String.valueOf(num1 + num2));
}

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
   calculate();
}