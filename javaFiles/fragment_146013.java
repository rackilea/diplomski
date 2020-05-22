public static long fibo(int n) {
    // Try cache first.
    if (cache[n] != 0) return cache[n];
    if (n == 0) 
        return 1;
    if (n < 2) 
        ans = 1;
    else
        ans = fibo(n - 1) + fibo(n - 2);
    // Don't subtract one.
    cache[n] = ans;
    return ans;
}