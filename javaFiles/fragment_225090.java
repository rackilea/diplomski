String input = "9X1X121: 1001, 1YXY2121: 2001, Role: ZZZZz";
String[] allParts = input.split(", ");
for (String part : allParts) {
    String[] parts = part.split(": ");
    /* parts[1] is what you need IF it's a number */    
}