while (true) {
    int ntz = Long.numberOfTrailingZeros(n);
    count += ntz;
    n >>>= ntz; // Using unsigned shift allows to work with bigger numbers.
    if (n==1) break;
    n = 3*n + 1;
    count++;
}