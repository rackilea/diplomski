private void cRadioButtonActionPerformed(ActionEvent evt) {
    try {

          String a = aTextField.getText();
          int i = Integer.parseInt(a);
          String b = bTextField.getText();
          int j = Integer.parseInt(b);
          int k = i * j;
          cTextField.setText(Integer.toString(k));

       } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null,
                "Error: You must enter an integer");

       } catch (ArithmeticException e) {
          JOptionPane.showMessageDialog(null,
                "Error: You cannot divide by zero");
    }
}