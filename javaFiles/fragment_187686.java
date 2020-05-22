public static String toUpper(String str) {
    if (str.length() < 1) {
        return "";
    }
    return Character.toUpperCase(str.charAt(0)) + toUpper(str.substring(1));
}