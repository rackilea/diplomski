JTextArea textArea = new JTextArea();
textArea.setText("this is java");
StringTokenizer stringTokenizer = new StringTokenizer(textArea.getText());
int position = 1;
while(stringTokenizer.hasMoreTokens())
{
    System.out.println("Position" + position + ":" + stringTokenizer.nextToken());
}