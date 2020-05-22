public GuessGame() {

  // Initialize window components
  mainFrame = new JFrame("Number Guessing Game");

  // ..... etc....

  FocusHandler fhandler = new FocusHandler();
  guessField.addFocusListener(fhandler);
  answerField.addFocusListener(fhandler);

  mainFrame.setVisible(true);
}