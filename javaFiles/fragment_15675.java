public static boolean digitsValid(String s) {
    for (int i = 1; i < s.length(); i++) {
        if (!Character.isDigit(s.charAt(i))) {
            return false;
        }
    }
    return true;
}