private HTMLDocument doc;
...
JTextPane jep = jTextPane1;
jep.setContentType("text/html");
jep.setText("<html><table><tr><td>A line of text</td></tr><tr><td>Another line of text</td></tr></table>");
doc = (HTMLDocument)jep.getStyledDocument();