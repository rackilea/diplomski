public static int nthIndexOf(String text, char needle, int n) {
    for (int i = 0; i < text.length(); i++) {
        if (text.charAt(i) == needle) {
            n--;
            if (n == 0) {
                return i;
            }
        }
    }
    return -1;
}