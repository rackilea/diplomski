JTextField textField = new JTextField(15);
textField.addFocusListener(new FocusAdapter() {

    @Override
    public void focusLost(FocusEvent e) {

        Component comp = e.getOppositeComponent();
        if (comp instanceof JButton) {
            JButton button = (JButton) comp;
            String buttonText = button.getText();
            if (buttonText.equals("Cancel")) {
                return;
            }
        }

        // do the validation
        System.out.println("validate");
    }

});