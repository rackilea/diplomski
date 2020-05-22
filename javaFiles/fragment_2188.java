static double[] solve(equation b, int k) {
    if (b.c > 1 || b.d > 0 || 1 > b.e || b.e > 0) {
        double[] a = new double[k];
        for (int i = 0; i < k; i++) {
            b.x0 = (b.c * b.x0) / (b.y0) + (b.d * b.x0);
            b.y0 = b.e * (b.x0 + 1) * b.y0;
            a[i] = b.y0;
        }
        return a;
    }
    return null;
}