long pow(long base, long exponent) {
    long result = 1;
    while(exponent > 0) {
        result *= base;
        --exponent;
    }
}