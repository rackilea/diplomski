long fibonacciIter(int n) {
    int m = 1;
    long fibPrev = 0;
    long fibCurrent = 1;
    while (n != m) {
        m = m + 1;
        int current = fibCurrent;
        fibCurrent = fibPrev + fibCurrent;
        fibPrev = current;
    }
    return fibCurrent;
}