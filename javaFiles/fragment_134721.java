public String solve(final String input) {

    // Get all individual characters from the input string
    char[] chars = new char[input.length()];
    input.getChars(0, input.length(), chars, 0);

    StringBuilder result = new StringBuilder();

    // Loop through each character
    for(int i = 0; i < chars.length; i++) {

        // If the character is the 1st, 3rd, 5th and so on
        // (i = 0 or i = 2 or i = 4 ...)
        if(i % 2 == 0) {
            // Shift one forward
            result.append(shift(chars[i], 1));

        // If the character is the 2nd, 4th, 6th and so on
        // (i = 1 or i = 3 or i = 5 ...)
        } else {
            // Shift one back
            result.append(shift(chars[i], -1));
        }
    }

    return result.toString();
}