public boolean overlap_1d(double aLow, double aHigh, double bLow, double bHigh)
{
    if (aLow <= bLow) return (bLow <= aHigh);
    /* else aLow > bLow */
    return (aLow <= bHigh);
}