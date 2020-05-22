jTextField.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isValid = true;

        try {
            int intVal = Integer.parseInt(jTextField.getText());
            if (intVal < 10 || intVal > 200) {
                isValid = false;
            }
        } catch (NumberFormatException x) {
            // user entered something which is not an int
            isValid = false;
        }

        if (!isValid) {
            jTextField.setText("100");
        }
    }
});