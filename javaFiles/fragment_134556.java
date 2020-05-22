//...Some other stuff
    public static double[][] rref(double[][] matrix, List<Integer> pivot) {
        double[][] rref = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            rref[i] = Arrays.copyOf(matrix[i], matrix[i].length);

        int r = 0;
        for (int c = 0; c < rref[0].length && r < rref.length; c++) {
            int j = r;
            for (int i = r + 1; i < rref.length; i++)
                if (Math.abs(rref[i][c]) > Math.abs(rref[j][c]))
                    j = i;
            if (Math.abs(rref[j][c]) < 0.00001)
                continue;

            //Remember where we pivoted
            pivot.add(j);

            double[] temp = rref[j];
            rref[j] = rref[r];
            rref[r] = temp;

            double s = 1.0 / rref[r][c];
            for (j = 0; j < rref[0].length; j++)
                rref[r][j] *= s;
            for (int i = 0; i < rref.length; i++) {
                if (i != r) {
                    double t = rref[i][c];
                    for (j = 0; j < rref[0].length; j++)
                        rref[i][j] -= t * rref[r][j];
                }
            }
            r++;
        }

        return rref;
    }

    public static RealMatrix kernel(RealMatrix A) {
        int m = A.getRowDimension(), n = A.getColumnDimension();
        List<Integer> pivot = new ArrayList<>();
        RealMatrix R = MatrixUtils.createRealMatrix(MatrixFunctions.rref(A.getData(), pivot));
        int r = pivot.size();
        HashMap<Integer, Integer> nopiv = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nopiv.put(i, i+1);
        }
        for (Integer e : pivot) {
            if (nopiv.containsValue(e+1))
                nopiv.remove(e, e+1);
        }
        //Remove ones contained inside pivot from nopiv
        for (int j = 0; j < r; j++) {
            int index = pivot.get(j);
            if (nopiv.containsValue(index))
                nopiv.remove(index);
        }

        double[][] Z = new double[n][n-r];    

        //Add 1(s) in the main diagonal
        if (n > r) {
            double[][] eye = new double[n-r][n-r];
            for (int i = 0; i < eye.length; i++) {
                for (int j = 0; j < eye[i].length; j++) {
                    if (j==i)
                        eye[i][j] = 1;
                    else
                        eye[i][j] = 0;
                }
            }
            //Add eye in Z
            Integer[] loc = nopiv.values().toArray(new Integer[nopiv.size()]);
            for (int i = 0; i < loc.length; i++) {
                int index = loc[i];
                for (int j = 0; j < Z[0].length; j++) {
                    Z[index-1][j] = eye[i][j];
                }
            }

            if (r > 0) {
                for (int i = 0; i < r; i++) {
                    int indexi = pivot.get(i);
                    for (int j = 0; j < loc.length; j++) {
                        int indexd = loc[j]-1;
                        Z[indexi][j] = -R.getEntry(i, indexd);
                    }
                }
            }
        }

        return MatrixUtils.createRealMatrix(Z);
    }
//...NnanananananaBATMAN!!