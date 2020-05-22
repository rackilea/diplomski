public String fileStream() {
  Object[] yesNo = { "Yes", "No"};
  int nn = JOptionPane.showOptionDialog(null,
        "Would you like to use previously entered data?", "Welcome Back?",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
        yesNo, yesNo[1]);
  if (nn == 0) {
     String savedBallNumber = readFromFile();
     return savedBallNumber;
  } else {
     String ballNumber = JOptionPane.showInputDialog("Please enter the number of balls you want on the screen:");
     return ballNumber;
  }
}