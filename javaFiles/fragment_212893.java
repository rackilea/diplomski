private static final int AM = 65521;

int getCCSuffix(String a) {
    int c = 1, b = 0, d = 0, e;
    char[] chars = a.toCharArray();
    for (e = 0; e < chars.length; e++) {
        d = chars[e];
        c = (c + d) % AM;
        b = (b + c) % AM;
    }
    return b << 16 | c;
}