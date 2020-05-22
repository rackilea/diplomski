StyledDocument document = textPane.getStyledDocument();
Style highlight = document.addStyle("highlight", null);
StyleConstants.setBackground(highlight, Color.YELLOW);

String text = document.getText(0, document.getLength());
while ((index = text.indexOf(myWord, index)) >= 0) {
    document.setCharacterAttributes(index, myWord.length(), highlight, false);
    index += myWord.length();
}