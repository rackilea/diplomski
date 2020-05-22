private static int getChannelValue(JTextField field) {
    String error;
    try {
        int value = Integer.parseInt(field.getText());
        if (value >= 0 && value <= 255)
            return value;
        error = "Out of range";
    } catch (NumberFormatException f) {
        error = "Not an integer number";
    }
    JOptionPane.showMessageDialog(null, "No. " + error);
    field.setText("");
    return -1; // invalid
}