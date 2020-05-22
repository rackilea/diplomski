public static String uniqueString(String[] s) {
    for (int i = 0; i < s.length; i++) {
        boolean unique = true;
        for (int j = i + 1; j < s.length; j++) {
            if (s[j].equals(s[i])) {
                s[j] = s[s.length - 1]; // <-- handle bug, ensure that dupes aren't
                                        // found again.
                unique = false;
                break;
            }
        }
        if (unique) {
            return s[i];
        }
    }
    return "";
}