public class SparseMatrix {

    // instance variables 
    private final TreeMap<Integer,TreeMap<Integer,Double>> matrix;
    private final int rows;
    private final int cols;

    public SparseMatrix(int r, int c) {
        this.rows = r;
        this.cols = c;
        this.matrix = new TreeMap<>();
    } // end of constructor

}