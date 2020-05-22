// Listen for changes in the text
taMessage.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {
        update();
    }

    public void removeUpdate(DocumentEvent e) {
        update();
    }

    public void insertUpdate(DocumentEvent e) {
        update();
    }

    public void update() {
        lblLength.setText(taMessage.getText().length()+"/ 160");
    }
});