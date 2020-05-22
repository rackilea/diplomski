public static int RoundToNearestRoundHalfToOdd(decimal value)
{
    // First round half toward positive infinity. Then if the fraction
    // part of the original value is 0.5 and the result of rounding is
    // even, then subtract one.
    var temp = (int)Math.Floor(value + 0.5m);
    if (value - Math.Floor(value) == 0.5m && temp % 2 == 0)
        temp -= 1;
    return temp;
}