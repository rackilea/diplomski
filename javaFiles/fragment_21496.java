/** Converts an input color given as a String such as "ab451e" to
 * the HSB color space. Shifts its hue from the given angle in degrees. 
 * Then returns the new color in the same format it was given.
 * 
 *  For example shift("ff0000", 180); returns "80ff00" (green is the opposite of red).*/
public static String shift(String rgbS, int angle) {        
    // Convert String to integer value
    int value = Integer.parseInt(rgbS, 16);

    // Separate red green and blue
    int r = value >> 16;
    int g = (value >> 8) & 0xff;
    int b = value & 0xff;

    // Convert to hsb
    float[] hsb = Color.RGBtoHSB(r, g, b, null);

    // Convert angle to floating point between 0 and 1.0
    float angleF = (float)(angle/360.0);

    // Shift the hue using the angle.
    float newAngle = hsb[0] + angleF;
    if(newAngle > 1.0)
        newAngle = newAngle - 1.0f;
    hsb[0] = newAngle;

    // Convert back to RGB, removing the alpha component
    int rgb = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
    rgb = rgb & 0xffffff;

    // Build a new String
    return Integer.toHexString(rgb);
}