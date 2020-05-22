// Use input to create printout
for (String output: goodMoves) {

    // Get numbers/character at each index of string
    char missNum = output.charAt(0);
    char cannNum = output.charAt(2);
    char boatPos = output.charAt(4);

    // Print number of M's and C's then concatenate them together
    missString = new String(new char[missNum]).replace("\0", "M");
    cannString = new String(new char[cannNum]).replace("\0", "C");

    // Concatenate both strings
    moveString = missString + cannString + boatPos + "\n";
}