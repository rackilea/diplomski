public static int PretoNonPre(int pre) {
    int a = pre >>> 24;
    if (a == 0xff || a == 0x00) return pre;
    int r = (pre >> 16) & 0xff;
    int g = (pre >>  8) & 0xff;
    int b = (pre      ) & 0xff;
    int halfa = a >> 1;
    r = (r >= a) ? 0xff : (r * 0xff + halfa) / a;
    g = (g >= a) ? 0xff : (g * 0xff + halfa) / a;
    b = (b >= a) ? 0xff : (b * 0xff + halfa) / a;
    return (a << 24) | (r << 16) | (g << 8) | b;
}