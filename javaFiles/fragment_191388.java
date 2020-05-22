boolean valid = false;
    do {
        final String userChoice = JOptionPane.showInputDialog(menu);
        final int numericChoice = Integer.parseInt(userChoice);
        JOptionPane.showMessageDialog(null, "You chose option " + userChoice);
        if (numericChoice == 1) {
            valid = true;
            // display the rules then start the game
            JOptionPane.showMessageDialog(null, rules);
        } else if (numericChoice == 2) {
            valid = true;
            // start the game
            JOptionPane.showMessageDialog(null, "Let's play the game.\n");
        } else if (numericChoice == 3) {
            valid = true;
            // exit the game
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Ivalid selection, please try again");
        }
    } while (!valid);