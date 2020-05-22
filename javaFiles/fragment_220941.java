@Override
    public void actionPerformed(ActionEvent e) {
        String idText = idTextField.getText().trim();
        try {
            int value = Integer.parseInt(idText);

            // if we have reached this line, then idText is numeric

            // code here to get Employee by value number

        } catch (NumberFormatException e1) {

            // don't show an error message here!
            // If we get here we know that idText is **not** numeric

            // code here to to get Employee by name using idText
        }
    }