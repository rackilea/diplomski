double payrate;
try {
    payrate = Double.parseDouble(jtfPayRate.getText().trim());
} catch (NumberFormatException nfe) {
    JOptionPane.showMessageDialog(null, "Please Enter Your Pay Rate");
}