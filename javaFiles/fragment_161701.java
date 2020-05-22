String text = "yusuf.png";
int endIndex = text.lastIndexOf(".");

JTextField field = new JTextField(text, 20);
if (endIndex > 0) {
    field.setSelectionStart(0);
    field.setSelectionEnd(endIndex);
} else {
    field.selectAll();
}