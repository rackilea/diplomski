public static int[][] generatePermutations(int N) {
    int[][] a = new int[factorial(N)][N];
    for (int i = 0; i < N; i++) a[0][i] = i;
    for (int i = 1; i < a.length; i++) {
        a[i] = Arrays.copyOf(a[i-1], N);
        int k, l;
        for (k = N - 2; a[i][k] >= a[i][k+1]; k--);
        for (l = N - 1; a[i][k] >= a[i][l]; l--);
        swap(a[i], k, l);
        for (int j = 1; k+j < N-j; j++) swap(a[i], k+j, N-j);
    }
    return a;
}
private static void swap(int[] is, int k, int l) {
    int tmp_k = is[k];
    int tmp_l = is[l];
    is[k] = tmp_l;
    is[l] = tmp_k;
}