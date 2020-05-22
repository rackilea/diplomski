// The variable 'parts' will contain 2 items:  your 2 integers, though they will still be String objects
String[] parts = myString.split("mod");

try {
    int firstInt = Integer.parseInt(parts[0]);
    int secondInt = Integer.parseInt(parts[1]);
) catch(NumberFormatException nfe) {
  // One of your Strings was not an integer value
}