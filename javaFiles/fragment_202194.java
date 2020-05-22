StyledDocument doc=(StyledDocument)textPane.getDocument();
doc.insertString(...);
SimpleAttributeSet attrs = new SimpleAttributeSet();
//StyleConstants.setFirstLineIndent(attrs, 50);
StyleConstants.setLeftIndent(attrs, 50);
doc.setParagraphAttributes(0,doc.getLength(),attrs, false);