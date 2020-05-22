public static Color hslColorToRgb(double hue, double saturation, double lightness) {
    if (saturation == 0.0) {
        // The color is achromatic (has no color)
        // Thus use its lightness for a grey-scale color
        int grey = percToColor(lightness);
        return new Color(grey, grey, grey);
    }

    double q;
    if (lightness < 0.5) {
        q = lightness * (1 + saturation);
    } else {
        q = lightness + saturation - lightness * saturation;
    }
    double p = 2 * lightness - q;

    double oneThird = 1.0 / 3;
    double red = percToColor(hueToRgb(p, q, hue + oneThird));
    double green = percToColor(hueToRgb(p, q, hue));
    double blue = percToColor(hueToRgb(p, q, hue - oneThird));

    return new Color(red, green, blue);
}