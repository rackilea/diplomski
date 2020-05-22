public char shift(char c, final int shift) {
    // Use -1 for subtracting
    if(shift == -1) {

        // Manually shift a to z when subtracting
        if(c == 'a') {
            return 'z';
        }

        // Otherwise just return the subtracted value
        return --c;
    }

    // Use 1 for adding
    if(shift == 1) {

        // Manually shift z to a when adding
        if(c == 'z') {
            return 'a';
        }

        // Otherwise just return the added value
        return ++c;
    }

    return c;
}