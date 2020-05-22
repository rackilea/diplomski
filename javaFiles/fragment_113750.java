static double[][] clone(double[][] a) {
    double[][] b = new double[a.length][];
    for (int i = 0; i < a.length; i++) {
        b[i]= new double[a[i].length];
        for (int j = 0; j < a[i].length; j++)
            b[i][j] = a[i][j];
    }
    return b;
}