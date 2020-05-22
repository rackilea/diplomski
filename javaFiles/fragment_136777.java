private static class RedDocumentListener implements DocumentListener {
    private JTextField textField;

    public RedDocumentListener(JTextField textField) {
        this.textField = textField;
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        textField.setBackground(Color.red);
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        textField.setBackground(Color.red);
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        textField.setBackground(Color.red);
    }
}