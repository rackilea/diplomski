public void actionPerformed(ActionEvent e) {
  String userText = text.getText();
  if (testIfTextValid(userText)) { // some method to test if input OK
    label.setText(INPUT_VALID);  // String constant for JLabel to display

    // here pass the userText to other parts of your code that needs to use it

  } else {
    label.setText(INPUT_INVALID);
  }
}