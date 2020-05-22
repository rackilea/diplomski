public static boolean isIncluded(Color target, Color pixel, int tolerance) {
    int rT = target.getRed();
    int gT = target.getGreen();
    int bT = target.getBlue();
    int rP = pixel.getRed();
    int gP = pixel.getGreen();
    int bP = pixel.getBlue();
    return(
        (rP-tolerance<=rT) && (rT<=rP+tolerance) &&
        (gP-tolerance<=gT) && (gT<=gP+tolerance) &&
        (bP-tolerance<=bT) && (bT<=bP+tolerance) );
}