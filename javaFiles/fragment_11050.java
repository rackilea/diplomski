public void actionPerformed(ActionEvent e)
{
String mathProblem = enterField.getText();
answerField.setText(answerField.getText() + "\r" + mathProblem + "=");
answerField.setText(answerField.getText() + solve(mathProblem));
}