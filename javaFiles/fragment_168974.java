public static double nextUp(double d) {
    if( isNaN(d) || d == Double.POSITIVE_INFINITY)
        return d;
    else {
        d += 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d) +
                                       ((d >= 0.0d)?+1L:-1L));
    }
}