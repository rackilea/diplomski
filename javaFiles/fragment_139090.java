private static int roundToNearestColor( int rgb, int nrColors )
{
    if (Integer.bitCount(nrColors) != 1) {
        throw new IllegalArgumentException("nrColors must be a power of two");
    }
    int mask = 0xFF & (-1 << Integer.numberOfTrailingZeros(nrColors));
    int red = ( rgb >> 16 ) & mask;
    int green = ( rgb >> 8 ) & mask;
    int blue = ( rgb & mask );
    return 0xFF000000 | ( red << 16 ) | ( green << 8 ) | ( blue );
}