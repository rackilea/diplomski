String[] questions = new String[x];
String[] answers = new String[x];
String[] a = new String[x];
String[] b = new String[x];
String[] c = new String[x];
String[] d = new String[x];

for (int i = 0; i < x; i++)
{

  questions[i] = JOptionPane.showInputDialog(null,"Please Enter Question Number "+i);
  a[i] = JOptionPane.showInputDialog(null,"What is the answer for a?");
  b[i] = JOptionPane.showInputDialog(null,"What is the answer for b?");
  c[i] = JOptionPane.showInputDialog(null,"What is the answer for c?");
  d[i] = JOptionPane.showInputDialog(null,"What is the answer for d?");
  answers[i] = JOptionPane.showInputDialog(null,"What is the correct answer to the question. \nType in lowercase a - d.");
}