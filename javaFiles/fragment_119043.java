public static void main(String[] args) {
    String veryLongString = "12345678901234567890";
    List<String> subStrings = splitter(veryLongString, 3);
    // Print the result
    for (String s : subStrings) {
        System.out.print(s + " ");
    }
}

public static List<String> splitter(String string, int interval) {
    int index = 0;
    List<String> subStrings = new ArrayList<String>();
    while (index < string.length()) {
        // Check if there is still enough characters to read.
        // If that is the case, remove it from the string.
        if (index + interval < string.length()) {
            subStrings.add(string.substring(index, index + interval));
        } else {
            // Else, less the "interval" amount of characters left,
            // Read the remaining characters.
            subStrings.add(string.substring(index, string.length()));
        }
        index += interval;
    }
    return subStrings;
}