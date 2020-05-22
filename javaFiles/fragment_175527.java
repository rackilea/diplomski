jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void changedUpdate(DocumentEvent evt) {
        dumpBinary(evt, jTextArea2);
    }
    @Override
    public void insertUpdate(DocumentEvent evt) {
        dumpBinary(evt, jTextArea2);
    }
    @Override
    public void removeUpdate(DocumentEvent evt) {
        dumpBinary(evt, jTextArea2);
    }
});