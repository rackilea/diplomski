public double[][] multiply(double[][] a, double[][] b) {
     assert a[0].length == b.length;
     double[][]c = new double[a.length][b[0].length];
     for(int i = 0, len1 = a.length; i < len1; a++) {
         for(int j = 0, len2 = b[0].length; j < len2; j++) {
              double sum = 0.0;
              for(int k = 0, len3 = b.length; k < len3; k++)
                  sum += a[i][k] * b[k][j];
              c[i][j] = sum;
         }
     }
}