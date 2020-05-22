for (int n = 1; n < 3; n++) {
    if (validationError) {
        if (n == 3) {
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Please complete each field within the order form.");
    } else {
        break;
    }
}

if (validationError = false) {
    JOptionPane.showMessageDialog(null, "Your order has been submitted!");
}
System.exit(0);