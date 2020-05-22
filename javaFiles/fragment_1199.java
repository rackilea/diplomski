public static long weightedSum(int[] a, int[] b, int n) {
    if (n == 0)
        return 0;
    else
        return a[n - 1] * b[n - 1] + weightedSum(a, b, n - 1);
}