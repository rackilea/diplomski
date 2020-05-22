public static int indexOf(char ch, String str) {
    // Returns the index of the of the character ch

    if (str == null || str.equals("")) {
        // base case: no more string to search; return -1
        return -1;
    } else if (ch == str.charAt(0)) {
        // base case: ch is at the beginning of str; return 0
        return 0; 
    }

    // recursive step
    int subIndex = indexOf(ch, str.substring(1));

    return subIndex == -1 ? -1 : 1 + subIndex;
}