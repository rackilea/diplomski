nextPower( int n ) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 4;
    return nextPower((n >> 1) | (n & 1)) << 1;
}