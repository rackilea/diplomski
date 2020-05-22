public static int parseInput(String input) {
    int number = 0;
    try {
        number = Integer.parseInt(input); 
    } catch (NumberFormatException ex) {
        someLabel.setText("Must be a number");
        return -1;  // return 0 
    }
}