public JTextPane createTextPane(String text){
  JTextPane textPane = new JTextPane();
  tp.setText(text);
  StyledDocument doc = textPane.getStyledDocument();
  SimpleAttributeSet center = new SimpleAttributeSet();
  StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
  doc.setParagraphAttributes(0, doc.getLength(), center, false);+
}