import cern.colt.matrix.DoubleMatrix1D;
    import cern.colt.matrix.DoubleMatrix2D;
    import cern.colt.matrix.doublealgo.Statistic;
    import cern.colt.matrix.impl.SparseDoubleMatrix2D;
    import cern.colt.matrix.linalg.Algebra;
    import cern.colt.matrix.linalg.EigenvalueDecomposition;
    import hep.aida.bin.DynamicBin1D;

    public class Pca {
        // to show matrix creation, it does not make much sense to calculate PCA on random data
        public static void main(String[] x) {
            double[][] data = {
                {2.0,4.0,1.0,4.0,4.0,1.0,5.0,5.0,5.0,2.0,1.0,4.0}, 
                {2.0,6.0,3.0,1.0,1.0,2.0,6.0,4.0,4.0,4.0,1.0,5.0},
                {3.0,4.0,4.0,4.0,2.0,3.0,5.0,6.0,3.0,1.0,1.0,1.0},
                {3.0,6.0,3.0,3.0,1.0,2.0,4.0,6.0,1.0,2.0,4.0,4.0}, 
                {1.0,6.0,4.0,2.0,2.0,2.0,3.0,4.0,6.0,3.0,4.0,1.0}, 
                {2.0,5.0,5.0,3.0,1.0,1.0,6.0,6.0,3.0,2.0,6.0,1.0}
            };

            DoubleMatrix2D matrix = new DenseDoubleMatrix2D(data);

            DoubleMatrix2D pm = pcaTransform(matrix);

            // print the first two dimensions of the transformed matrix - they capture most of the variance of the original data
            System.out.println(pm.viewPart(0, 0, pm.rows(), 2).toString());
        }

        /** Returns a matrix in the space of principal components, take the first n columns  */
        public static DoubleMatrix2D pcaTransform(DoubleMatrix2D matrix) {
            DoubleMatrix2D zScoresMatrix = toZScores(matrix);
            final DoubleMatrix2D covarianceMatrix = Statistic.covariance(zScoresMatrix);

            // compute eigenvalues and eigenvectors of the covariance matrix (flip needed since it is sorted by ascending).
            final EigenvalueDecomposition decomp = new EigenvalueDecomposition(covarianceMatrix);

            // Columns of Vs are eigenvectors = principal components = base of the new space; ordered by decreasing variance
            final DoubleMatrix2D Vs = decomp.getV().viewColumnFlip(); 

            // eigenvalues: ev(i) / sum(ev) is the percentage of variance captured by i-th column of Vs
            // final DoubleMatrix1D ev = decomp.getRealEigenvalues().viewFlip();

            // project the original matrix to the pca space
            return Algebra.DEFAULT.mult(zScoresMatrix, Vs);
        }


        /**
         * Converts matrix to a matrix of z-scores (by columns)
         */
        public static DoubleMatrix2D toZScores(final DoubleMatrix2D matrix) {
            final DoubleMatrix2D zMatrix = new SparseDoubleMatrix2D(matrix.rows(), matrix.columns());
            for (int c = 0; c < matrix.columns(); c++) {
                final DoubleMatrix1D column = matrix.viewColumn(c);
                final DynamicBin1D bin = Statistic.bin(column);

                if (bin.standardDeviation() == 0) {   // use epsilon
                    for (int r = 0; r < matrix.rows(); r++) {
                        zMatrix.set(r, c, 0.0);
                    }
                } else {
                    for (int r = 0; r < matrix.rows(); r++) {
                        double zScore = (column.get(r) - bin.mean()) / bin.standardDeviation();
                        zMatrix.set(r, c, zScore);
                    }
                }
            }

            return zMatrix;
        }
    }