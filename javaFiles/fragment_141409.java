public int powerN(int base, int n) {
    int result = 1;
    for (int i = 0; i < n; i++) {
        result *= base;
    }

    return result;
}