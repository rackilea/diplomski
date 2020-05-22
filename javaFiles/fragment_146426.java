double feet;
try {
    feet = Double.parseDouble(jTextField1.getText());
} catch (NumberFormatException e) {
    feet = 0;
}
double inches;
try {
    inches = Double.parseDouble(jTextField2.getText());
} catch (NumberFormatException e) {
    inches = 0;
}