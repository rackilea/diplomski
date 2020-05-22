static int powerN(int base, int n) {
    if (n == 0) {
        return 1;
    } else if (n == 1) {
        return base;
    }
    return base * powerN(base, n - 1);
}