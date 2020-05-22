String word = JOptionPane.showInputDialog("Enter 3 int values");
String[] vals = word.split("\\s+"); // split the sting by whitespaces accepts regex. 
// vals[0] cast to int
// convert string representation of number into actual int value
int day = Integer.parseInt(vals[0]); // throws NumberFormatException
// vals[1] cast to int
// vals[2] cast to int