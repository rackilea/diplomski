public static String getSettings() {
  String input = JOptionPane.showInputDialog(null, "Class: ",
        "Insert Settings", JOptionPane.QUESTION_MESSAGE);

  return String.format("class=\"%s\"", input);
}