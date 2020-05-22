private final JTextField fontSetter;
private final JTextField textfield;
private final Font font;

Bold(JTextField fontSetter, JTextField textfield) {
    this.fontSetter = fontSetter;
    this.textfield = textfield;
    this.font = new Font(textfield.getText(), Font.BOLD, 12);
}