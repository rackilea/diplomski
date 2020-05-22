public static long round(double a) {
    if (a != 0x1.fffffffffffffp-2) // greatest double value less than 0.5
        return (long)floor(a + 0.5d);
    else
        return 0;
}