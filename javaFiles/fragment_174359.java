public class SparseMatrixTest extends TestCase {
    public void testMatrix() {
        SparseMatrix<Float> matrix = 
            new SparseMatrix<Float>(100000, 100000, 0.0F);
        matrix.setValueAt(1000, 1001, 42.0F);
        assertTrue(matrix.getValueAt(1000,1001) == 42.0);
        assertTrue(matrix.getValueAt(1001,1000) == 0.0);        
    }   
}