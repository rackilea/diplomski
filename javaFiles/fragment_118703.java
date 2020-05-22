String errorMessage = "";
do {
    // Show input dialog with current error message, if any
    String stringInput = JOptionPane.showInputDialog(errorMessage + "Enter number.");
    try {
        int number = Integer.parseInt(stringInput);
        if (number > 10 || number < 0) {
            errorMessage = "That number is not within the \n" + "allowed range!\n";
        } else {
            JOptionPane
                .showMessageDialog(null, "The number you chose is " + number + ".");
            errorMessage = ""; // no more error
        }
    } catch (NumberFormatException e) {
        // The typed text was not an integer
        errorMessage = "The text you typed is not a number.\n";
    }
} while (!errorMessage.isEmpty());