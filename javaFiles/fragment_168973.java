public static double nextDouble(double d)
{
    if (d != d) return d;
    if (d == Double.MAX_VALUE) return Double.POSITIVE_INFINITY;
    if (d == Double.NEGATIVE_INFINITY) return d;
    if (d == Double.POSITIVE_INFINITY) return d;

    d += 0.0;
    int dir = d < 0.0 ? -1 : 1; 
    return Double.longBitsToDouble(Double.doubleToLongBits(d) + dir);
}