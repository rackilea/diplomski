public static String replaceCharacter(String w, char b, String v) {
    String result = "";
    for (int i = 0; i < w.length(); i++) {
        if (w.charAt(i) == b) {
            result += v;
        } else {
            result += w.charAt(i);
        }
    }
    return result;
}