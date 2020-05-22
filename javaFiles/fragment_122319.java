public static void main(String[] args) {
    String value = JOptionPane.showInputDialog(null, "Please enter a year to calculate Easter Sunday", null, JOptionPane.PLAIN_MESSAGE);
    int inputted = 0;
    do {
        try {
            inputted = Integer.parseInt(value);
            if (inputted <= 0) {
                inputted = 0;
                value = JOptionPane.showInputDialog(null, "Expected a positive year. Please try again:", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exp) {
            inputted = 0;
            value = JOptionPane.showInputDialog(null, value + " is not a valid number. Please try again:", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } while (inputted == 0);
}