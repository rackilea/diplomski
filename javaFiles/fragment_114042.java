private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    String text = jTextField1.getText().trim();
    try {
      // the String to int conversion happens here
      int numberOne = Integer.parseInt(text);

      String answer = calc.calculateNumbers(numberOne, numberTwo);
      jLabel1.setText(answer);

    } catch (NumberFormatException nfe) {
      jLabel1.setText(text + " is not an integer... ");
    }
}