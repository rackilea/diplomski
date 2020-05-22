public static double eThree(double x, long n) {
    return eThree(x, n, 1);
}

private static double eThree(double x, long n, int div) {
    double d = 1;
    if (n > 0) {
        d = d + (x / div) * (eThree(x, n - 1, div + 1));
    }
    return d;
}