public static Color transitionOfHueRange(double percentage, int startHue, int endHue) {
    // From 'startHue' 'percentage'-many to 'endHue'
    // Finally map from [0°, 360°] -> [0, 1.0] by dividing
    double hue = ((percentage * (endHue - startHue)) + startHue) / 360;

    double saturation = 1.0;
    double lightness = 0.5;

    // Get the color
    return hslColorToRgb(hue, saturation, lightness);
}