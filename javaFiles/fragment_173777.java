DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
String text = ((String) node.getUserObject());
String newText = "<html><FONT COLOR=ORANGE size=\\\"2\\\"><B>" + text + "</B></FONT></html>";
setText(newText);

return this;