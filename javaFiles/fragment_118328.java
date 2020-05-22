public static double[][] matrixMultiply(double[][] m, double[][] n) {
        double[][] multipliedMatrix = new double [m.length][n[0].length];
        for (int i=0; i<m.length; i++)
        {
            for (int j=0; j<n[0].length; j++)
            {
                for (int k=0; k<n.length; k++)
                {
                    multipliedMatrix[i][j] = multipliedMatrix[i][j] + (m[i][k] * n[k][j]);
                }
            }
        }
        return multipliedMatrix;
    }