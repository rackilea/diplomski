private void htmlHighlight() {
    String textToScan;
        textToScan = txtrEdit.getText();
        StyledDocument doc = txtrEdit.getStyledDocument(); 
        SimpleAttributeSet sas = new SimpleAttributeSet();
        while(textToScan.contains(">")) {
            StyleConstants.setForeground(sas, new Color(0xEB13B1));
            StyleConstants.setBold(sas, true);
            int start = textToScan.indexOf('<');
            int end = textToScan.indexOf('>')+1;
            doc.setCharacterAttributes(start, end-start, sas, false);
            textToScan = textToScan.substring(textToScan.indexOf('>') + 1, textToScan.length());
        }

}