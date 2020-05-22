tf = new JTextField(20);
tf.getDocument().addDocumentListener(new DocumentListener() {

    protected void update() {
        p.setEnabled(tf.getText().trim().length() > 0);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        update();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        update();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        update();
    }
});