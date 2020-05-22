private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
    StyledDocument doc = textPane.getStyledDocument();
    int start = textPane.getSelectionStart();
    int end = textPane.getSelectionEnd();
    if (start == end) { // No selection, cursor position.
        return;
    }
    if (start > end) { // Backwards selection?
        int life = start;
        start = end;
        end = life;
    }
    Style style = textPane.addStyle("MyHilite", null);
    StyleConstants.setForeground(style, Color.GREEN.darker());
    //style = textPane.getStyle("MyHilite");
    doc.setCharacterAttributes(start, end - start, style, false);
}