DefaultStyledDocument document = new DefaultStyledDocument();
JTextPane textpane = new JTextPane(document);
StyleContext context = new StyleContext();
// build a style
Style style = context.addStyle("test", null);
// set some style properties
StyleConstants.setForeground(style, Color.BLUE);
// add some data to the document
document.insertString(0, "", style);