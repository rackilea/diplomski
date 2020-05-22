public enum MatrixFactory {

    /**
     * Creates a diagonal matrix
     * 
     * args[0] : a double[] with the diagonal values
     */
    DIAGONAL_MATRIX {
        @Override
        public MainMatrix create(Object[] args) {
            double[] diagonal = (double[]) args[0];
            return new DiagonalMatrix(diagonal);
        }
    },

    /**
     * Creates a full matrix
     * 
     * args[0] : the number of rows
     * 
     * args[1] : the number of columns
     */
    FULL_MATRIX() {
        @Override
        public MainMatrix create(Object[] args) {
            int rows = (Integer) args[0];
            int cols = (Integer) args[1];
            return new FullMatrix(rows, cols);
        }
    };

    public abstract MainMatrix create(Object[] args);
}