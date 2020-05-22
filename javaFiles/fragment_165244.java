String text = jTextPane.getSelectedText();
int cursorPosition = jTextPane.getCaretPosition();

StyleContext context = new StyleContext();
Style style;

jTextPane.replaceSelection("");

style = context.addStyle("mystyle", null);
style.addAttribute(StyleConstants.FontSize, new Integer(16));
jTextPane.getStyledDocument().insertString(cursorPosition - text.length(), text, style);