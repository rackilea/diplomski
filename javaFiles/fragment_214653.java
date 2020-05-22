JPasswordField passField = new JPasswordField(10);
  Object[] inputs = {passField, "OK", "Cancel"};
  int res = JOptionPane.showOptionDialog(null, "Enter Password", "Login", 
           JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
           null, inputs, "");
  if (res == 1) {
     System.out.println("Password is: " + new String(passField.getPassword()));
  }