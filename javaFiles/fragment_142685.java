private static char[] ONLY_LETTERS_TO_LOWERCASE = new char[65535];

static {
    ONLY_LETTERS_TO_LOWERCASE[' '] = ' ';
    for (char c = 'a'; c <= 'z'; c++) {
        ONLY_LETTERS_TO_LOWERCASE[c] = c;
    }
    for (char c = 'A'; c <= 'Z'; c++) {
        ONLY_LETTERS_TO_LOWERCASE[c] = Character.toLowerCase(c);
    }
}