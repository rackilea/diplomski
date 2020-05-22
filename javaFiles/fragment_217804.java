...
String firstAnswer;
String secondAnswer;
...

private FirstQuestionActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent e) {
     firstAnswer = e.getActionCommand();
  }
}

private SecondQuestionActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent e) {
     secondAnswer = e.getActionCommand();
  }
}