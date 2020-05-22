private static int blend(int foreground, int background, int alpha, int shift) {
    int fg = (foreground >>> shift) & 0xff;
    int bg = (background >>> shift) & 0xff;
    return (fg * alpha + bg * (256 - alpha)) >>> 8 << shift;
}

public static int alphaBlend(int foreground, int background) {
    int alpha = foreground >>> 24;
    int R = blend(foreground, background, alpha, 0);
    int G = blend(foreground, background, alpha, 8);
    int B = blend(foreground, background, alpha, 16);
    return R | G | B;
}