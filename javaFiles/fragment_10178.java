private static boolean isWord(String str) {
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
            return false;
        }
    }
    return true;
}