int rows = a.length;
int cols = a[0].length;
double[][] res = new double[rows][cols];

Arrays.parallelSetAll(res, i -> {
    Arrays.parallelSetAll(res[i], j -> a[i][j] + b[i][j]);
    return res[i];
});