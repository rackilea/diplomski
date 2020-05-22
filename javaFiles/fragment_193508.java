MyFrame2 myFrame2 = new MyFrame2();
myFrame2.setVisible(true);

String text = myFrame2.getMyTextFieldText();
if (text != null && !text.trim().isEmpty()) {
  int someNumber = Integer.parseInt(text);
}