// Get the input; this could be an array of ints or strings, either will work
int numberBox[] = gatherInput();

// Convert the array into a String form: "[1, 2, 3, 4, 5]"
final String numbers = Arrays.toString( numberBox );

// And show a simple dialog box with the numbers
JOptionPane.showMessageDialog( null, numbers );