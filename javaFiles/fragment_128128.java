static int checksum(int x) {
    long n = x;
    int sum = 0;
    while (n != 0) {
        long d = 1000000000l;
        int digit = (int) (n / d);
        n %= d;
        n *= 10l;
        // add digit to sum
    }
    return sum;
}