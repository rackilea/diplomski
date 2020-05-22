String text = txtpane.getText();
String[] words  text.split("\\W");
// or: String[] words = txtpane.getText().split("\\W")
for (String word : words) {
    System.out.println(word);
    // do whatever
}