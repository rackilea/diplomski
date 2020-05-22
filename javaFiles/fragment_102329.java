JFormattedTextField textField = new JFormattedTextField("This is a test");
textField.setValue(0.8d);
add(textField, gbc);
textField.addFocusListener(new FocusAdapter() {
    @Override
    public void focusGained(FocusEvent arg0) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                textField.setCaretPosition(textField.getText().length());
            }
        });
    }
});