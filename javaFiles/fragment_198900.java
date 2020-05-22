public static void main(String[] args) {
    int num = 0, den = 0;

    DivisionExceptions div = new DivisionExceptions();

    while(true) {
        try {
            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce the first int"));
            break;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error of type: " + e.getMessage() + ". Verify the information and try again.");
        }
    }

    while (true) {
        try {
            den = Integer.parseInt(JOptionPane.showInputDialog("Introduce the second int"));
            JOptionPane.showMessageDialog(null, "Result of dividing: " + num + "/" + den + " is " + div.divide(num, den));
            break;
        } catch (NumberFormatException | ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Error of type: " + e.getMessage() + ". Verify the information and try again.");
        }
    }
}