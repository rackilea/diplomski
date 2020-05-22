SimpleAttributeSet normal = new SimpleAttributeSet();
StyleConstants.setFontFamily(normal, "SansSerif");
StyleConstants.setFontSize(normal, 16);

SimpleAttributeSet bold = new SimpleAttributeSet(normal);
StyleConstants.setBold(bold, true);

SimpleAttributeSet italic = new SimpleAttributeSet(normal);
StyleConstants.setItalic(italic, true);

doc.insertString(doc.getLength(), s + "\n", normal);
doc.insertString(doc.getLength(), s + "\n", bold);
doc.insertString(doc.getLength(), s + "\n", italic);