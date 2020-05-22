public class MatrixFactory {

    /**
     * Creates a diagonal matrix
     * 
     * @param diagonal the diagonal values
     * @return
     */
    public static MainMatrix diagonalMatrix(double[] diagonal) {
        return new DiagonalMatrix(diagonal);
    }

    /**
     * Creates a full matrix
     * 
     * @param rows the number of rows
     * @param cols the number of columns
     * @return
     */
    public static MainMatrix fullMatrix(int rows, int cols) {
        return new FullMatrix(rows, cols);
    }
}