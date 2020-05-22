Scanner stdIn = new Scanner(System.in);
System.out.println("Please enter a string of any length: "); 
// Read the input string as a complete line
String convertMe = stdIn.nextLine(); 

// Establish a Header in console display
System.out.printf("%s%15s%15s%10s%n", "Initial", "ASCII<char>", "ASCII<int>", "Hex");
// Create a header underline in console display
System.out.println(String.join("", Collections.nCopies(29, "\u2500")));

String displayFormat;
for(int x = 0; x < convertMe.length(); x++) {
    String c = Character.toString(convertMe.charAt(x));
    // Create a display format to accomodate whether
    // or not the character is alpha or numeric.
    // Is the character numeric?
    if (c.matches("\\d")) {
        displayFormat = "%4c %28d %13x %n";
    }
    // Nope..it's a alpha character
    else {
        displayFormat = "%4c %13d %28x %n";
    }
    int ascii = c.charAt(0); 
    System.out.printf(displayFormat, convertMe.charAt(x), ascii, ascii); 
}
System.out.printf("%n"); 
System.out.println("Thank you for playing!");