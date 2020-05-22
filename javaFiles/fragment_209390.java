textField.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void removeUpdate(DocumentEvent e) {
        lblNewLabel.setText(textField.getText());
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        lblNewLabel.setText(textField.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
});