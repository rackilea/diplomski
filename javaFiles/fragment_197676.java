JTextPane textPane = new JTextPane();
Style bold = textPane.addStyle("bold", null);
StyleConstants.setBold(bold, true);

textPane.setText("I'll be bold.");

textPane.getStyledDocument().setCharacterAttributes(8, 4, bold, true);