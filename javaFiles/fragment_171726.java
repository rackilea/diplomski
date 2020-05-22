long pow(long base, long exponent) {
    long aux = 1;
    while(exponent > 0) {
        if (exponent % 2 == 1) {
            aux *= base;
        }
        base *= base;
        exponent /= 2;
    }
    return aux;
}