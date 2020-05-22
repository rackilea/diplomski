do {
    pInput2 = JOptionPane.showInputDialog(null, "Please re-enter your password: \n");

    }
while (compare(pInput, pInput2) == false);

if (compare(pInput, pInput2) == true) {
    //if input is validated and returns true- finish program
    JOptionPane.showMessageDialog(null, "Your password was successfully entered.");
}