int number1, number2;
try {
    number1 = Integer.parseInt(
            this.firstInput.getText());


} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Bad first number", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
try {
    number2 = Integer.parseInt(
            this.secondInput.getText());
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Bad second number", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
if (number2 == 0) {
    JOptionPane.showMessageDialog(this, "Cannot divide by 0", "Error", JOptionPane.ERROR_MESSAGE);
} else {
    int answer = number1 / number2;
    this.theAnswer.setText(
            "The calculated answer is: " + answer);            
}