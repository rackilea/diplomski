public static int tintABGRPixel(int pixelColor, Color tintColor) {
    //Calculate the luminance. The decimal values are pre-determined.
    int x = pixelColor>>16 & 0xff, y = pixelColor>>8 & 0xff, z = pixelColor & 0xff;
    int top = 2126*x + 7252*y + 722*z;
    int Btemp = (int)((tintColor.getBlue() * top * 1766117501L) >> 52);
    int Gtemp = (int)((tintColor.getGreen() * top * 1766117501L) >> 52);
    int Rtemp = (int)((tintColor.getRed() * top * 1766117501L) >> 52);

    //Calculate the new tinted color of the pixel and return it.
    return ((pixelColor>>24 & 0xff) << 24) | Btemp & 0xff | (Gtemp & 0xff) << 8 | (Rtemp & 0xff) << 16;
}