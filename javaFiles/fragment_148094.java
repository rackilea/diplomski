saveAmount = 0.0;
String result;
while (saveAmount <= 0) {
    result = JOptionPane.showInputDialog(null, "Enter how much money you can save annually.")
    if (result != null) {
        saveAmount = Double.parseDouble(result);
        if (saveAmount < 0.0) {
            JOptionPane.showMessageDialog(null, "Pick a number greater than 0!");
        }
    }
}