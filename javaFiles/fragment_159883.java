public static boolean isSSWS(String s) {
    boolean isWhiteSpace = false;
    boolean isPreviousCharDigit = false;

    for (char c : s.toCharArray()) {
        if (!isPreviousCharDigit || !Character.isDigit(c)) {
            if (c == ' ' && !isWhiteSpace) {
                return false;
            }
            if (c != ' ' && isWhiteSpace) {
                return false;
            }
            isWhiteSpace = !isWhiteSpace;
        }
        isPreviousCharDigit = Character.isDigit(c);
    }
    return true;
}