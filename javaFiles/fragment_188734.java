public static int funct(int n) {
    int[] results = new int[n+1];
    results[0] = 1;
    results[1] = 2;
    int i = 2;
    while (i <= n) {
        results[i] = results[i-2] * results[i/2];
        ++i;
    }
    return results[n];
}