public static String reduce(String w) {
    if (w == null) return null;         // in case if w is NULL
    String result = "";
    result += w.charAt(0);
    for (int i = 1; i < w.length(); i++) {
        if (w.charAt(i - 1) != w.charAt(i)) {
            result += w.charAt(i);
        }
    }
    return result;
}