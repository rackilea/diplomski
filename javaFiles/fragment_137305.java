public static double min(double a, double b) {
    if (a != a) return a;   // a is NaN
    if ((a == 0.0d) && (b == 0.0d) && (Double.doubleToLongBits(b) == negativeZeroDoubleBits)) {
        return b;
    }
    return (a <= b) ? a : b;
}