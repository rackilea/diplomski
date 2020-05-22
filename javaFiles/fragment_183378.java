public static int compare(String a, String b) {
    if (a == null) {
        return b == null ? 0 : -1;
    } else if (b == null) {
        return 1;
    }
    String alow = a.toLowerCase();
    String blow = b.toLowerCase();
    int len = Math.min(a.length(), b.length());
    for (int i = 0; i < len; i++) {
        int d = alow.charAt(i) - blow.charAt(i);
        if (d != 0) {
            return d < 0 ? -1 : 1;
        }
    }
    int diff = a.length() - len;
    if (diff != 0) {
        return diff < 0 ? -1 : 1;
    }
    return 0;
}