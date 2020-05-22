JSpinner.DefaultEditor editor =
    (JSpinner.DefaultEditor) spinner.getEditor();

editor.getTextField().addFocusListener(new FocusAdapter() {
    @Override
    public void focusGained(FocusEvent event) {
        final JTextField textField = (JTextField) event.getComponent();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        textField.selectAll();
                    }
                });
            }
        });
    }
});