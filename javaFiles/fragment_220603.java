int numLines = Integer.parseInt(showInputDialog("type here "));
for(int numAsterisks = 0; numAsterisks < numLines; numAsterisks++) {
    for(int i = 0; i < numAsterisks; i++) {
        System.out.print("*");
    }
    System.out.println(); // Start a new line
}