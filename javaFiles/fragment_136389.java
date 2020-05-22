Simple AttributeSet changed = new SimpleAttributeSet();
StyleConstants.setForeground(changed, Color.RED);
StyleConstants.setBackground(changed, Color.YELLOW);

//  Change attributes on some text

StyledDocument doc = textPane.getStyledDocument();
doc.setCharacterAttributes(20, 4, changed, false);