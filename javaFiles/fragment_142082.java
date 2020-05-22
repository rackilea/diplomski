public static boolean matchesMyPattern(String s) {
    boolean withUnderscore = s.contains("_");

    int[] found = new int[26];

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch != '_' && (ch < 'A' || ch > 'Z')) {
            return false;
        }

        if (ch != '_' && i > 0 && s.charAt(i - 1) != ch && found[ch - 'A'] > 0
                && !withUnderscore) {
            return false;
        }
        if (ch != '_') {
            found[ch - 'A']++;
        }
    }

    for (int i = 0; i < found.length; i++) {
        if (found[i] == 1) {
            return false;
        }
    }

    return true;
}