// How many times retries has the user used...
private int retries = 0;

/*...*/

public void actionPerformed(ActionEvent e) {

    validationError = (fNameInput.getText().equals("")
            || miInput.getText().equals("")
            || lNameInput.getText().equals("")
            || streetAddressInput.getText().equals("")
            || cityInput.getText().equals("")
            || stateInput.getText().equals("")
            || zipInput.getText().equals("")
            || phoneInput.getText().equals(""));

    if (validationError) {
        retries++;
        if (retries < 3) {
            JOptionPane.showMessageDialog(this, "Please complete each field within the order form.");
        } else {
            JOptionPane.showMessageDialog(this, "You've used up all your tries...");
            System.exit(0);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Your order has been submitted!");
        System.exit(0);
    }
}