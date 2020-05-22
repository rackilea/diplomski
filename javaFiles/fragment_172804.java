int[][] powerMatrix (int[][] a, int p) {
    int[][] result = a;
    for (int n = 1; n < p; ++ n)
        result = multiplyMatrices(result, a);
    return result;
}