public static int sumDigits(int n) {
    int retVar = 0;
    while (n > 0) {
        int d;
        for (d = 1; d < n; d *= 10);

        d /= 10;
        retVar += n / d;
        n %= d;
    }
    return retVar;
}