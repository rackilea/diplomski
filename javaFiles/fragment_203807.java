public static boolean isValidJavaIdentifier(String s) {
    if (s.isEmpty()) {
        return false;
    }
    if (!Character.isJavaIdentifierStart(s.charAt(0))) {
        return false;
    }
    for (int i = 1; i < s.length(); i++) {
        if (!Character.isJavaIdentifierPart(s.charAt(i))) {
            return false;
        }
    }
    return true;
}