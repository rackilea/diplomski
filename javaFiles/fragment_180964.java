oneButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent oneButton) {
        if(StringUtils.isEmpty(textField)) {
            // If its empty so just put 1 in the display
            textField.setText("1");
        } else {
            // Get value on display and convert to a integer
            // Plus one because its the button one
            int result = 1 + Integer.parseInt(textField.getText());
            // Set the result to the display
            textField.setText((String) result);
        }
    }
});