private static String rewriteBitMask(String token) {
    int result = 0;
    for (int i = 2; i < token.length(); ++i) {
        char character = token.charAt(i);
        if (character != '_') {
            int bit = Character.digit(character, 2);
            result = result << 1;
            result |= bit;
        }
    }
    return Integer.toString(result);
}