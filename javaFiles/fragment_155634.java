try {
    String textToScan;
    textToScan = txtrEdit.getText();
    StyledDocument doc = new DefaultStyledDocument();
    SimpleAttributeSet sas = new SimpleAttributeSet();
    StyleConstants.setForeground(sas, new Color(0xEB13B1));
    StyleConstants.setBold(sas, true);
    int end = 0;
    while (true) {
        int start = textToScan.indexOf('<', end);
        if (start < 0) {
            doc.insertString(end, textToScan.substring(end), null);
            break;
        }
        doc.insertString(end, textToScan.substring(end, start), null);
        end = textToScan.indexOf('>', start+1);
        if (end < 0) {
            doc.insertString(start, textToScan.substring(start), sas);
            break;
        }
        ++end;
        doc.insertString(start, textToScan.substring(start, end), sas);
    }
    txtrEdit.setStyledDocument(doc);
} catch (BadLocationException ex) {
    Logger.getLogger(MyDialog.class.getName()).log(Level.SEVERE, null, ex);
}