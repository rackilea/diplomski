int i=0; // create a counter
do {
    option = JOptionPane.showConfirmDialog(null,"Want to enter another useraName?");
    i++; // increment the counter
} while (option == JOptionPane.YES_OPTION);
JOptionPane.showMessageDialog(null, "you have entered " + i + " names"); // use it