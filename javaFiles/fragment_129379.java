long fibonacci(int n) {
    if (n == 0)
        return 0;
    else
        return fibonacciTail(n, 1, 0, 1);
}

long fibonacciTail(int n, int m, long fibPrev, long fibCurrent) {
    if (n == m)
        return fibCurrent;
    else
        return fibonacciTail(n, m + 1, fibCurrent, fibPrev + fibCurrent);
}