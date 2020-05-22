import java.io.IOException;
import org.la4j.matrix.sparse.CCSMatrix;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] indices = new int[]{0, 2, 2, 0, 1, 2};
        int[] indptr = new int[]{0,2,3,6};
        double[] data = new int[]{1, 2, 3, 4, 5, 6};
        int[] shape = new int[]{3,3};
        // some code to create 2D arrays
        CCSMatrix a = new CCSMatrix(shape[0],shape[1],data.length,data,indices,indptr);
        double[][] mat = a.toDenseMatrix().toArray();
    }
}