while (true) {
    addAnother = JOptionPane.showInputDialog("Would you like to enter another salespersons' data?");

    if (validOptions.contains(addAnother)) {
        break;
    }

    System.out.println("Not a valid option");
}