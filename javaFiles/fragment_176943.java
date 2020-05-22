public static int count(char d) {
    int sum = 0; 

    // Iterate over all the strings in Layout.ROWS:
    for (String str : Layout.ROWS) {
        // Iterate over the chars of the string:
        for (int i = 0; i < str.length(); ++i) {
            if (d == str.charAt(i)) {
                ++sum;
            }
        }
    }
    return sum;
}