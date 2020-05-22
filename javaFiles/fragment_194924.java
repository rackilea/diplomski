public static int getSmallestPossibleBase(String value) {
    int max = 0;
    for (char c : value.toCharArray()) {
        int type = Character.getType(c);
        switch (type) {
            case Character.DECIMAL_DIGIT_NUMBER:
                // Decimal digit.
                max = Math.max(max, c - '0');
                break;
            case Character.UPPERCASE_LETTER:
            case Character.LOWERCASE_LETTER:
                // Works for base 16 and 32/36.
                max = Math.max(max, Character.toLowerCase(c) - 'a' + 10);
                break;
            default:
                throw new IllegalArgumentException("Your argument is invalid");
        }
    }
    return max + 1;
}