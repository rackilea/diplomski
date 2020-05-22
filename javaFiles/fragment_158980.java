public Color brighter() {
    int r = getRed();
    int g = getGreen();
    int b = getBlue();
    int alpha = getAlpha();

    /* From 2D group:
     * 1. black.brighter() should return grey
     * 2. applying brighter to blue will always return blue, brighter
     * 3. non pure color (non zero rgb) will eventually return white
     */
    int i = (int)(1.0/(1.0-FACTOR));
    if ( r == 0 && g == 0 && b == 0) {
        return new Color(i, i, i, alpha);
    }
    if ( r > 0 && r < i ) r = i;
    if ( g > 0 && g < i ) g = i;
    if ( b > 0 && b < i ) b = i;

    return new Color(Math.min((int)(r/FACTOR), 255),
                     Math.min((int)(g/FACTOR), 255),
                     Math.min((int)(b/FACTOR), 255),
                     alpha);
}