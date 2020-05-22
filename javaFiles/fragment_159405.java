public static String sub(String a, String b) {
    if (b.startsWith(a)) {
        return b.subString(a.length());
    }

    if (b.endsWith(a)) {
        return b.subString(0, b.length() - a.length());
    }

    return "";
}