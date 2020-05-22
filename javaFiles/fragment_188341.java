do {
        pInput2 = JOptionPane.showInputDialog(null, "Please re-enter your password: \n");
    } while (!pInput.equals(pInput2));

    if (pInput.equals(pInput2)) {
        //if input is validated and returns true- finish program
        JOptionPane.showMessageDialog(null, "Your password was successfully entered.");
    }