import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Matrix {

@FunctionalInterface
interface MatrixOperation<Matrix, Integer> {
    public void apply(Matrix m1, Matrix m2, Matrix m3, Integer i, Integer j);
}
private final static MatrixOperation<Matrix, Integer> addFunc = (m1, m2, m3, i, j) -> {
    double value = m1.get(i, j) + m2.get(i, j);
    m3.set(i, j, value);
};
private final static MatrixOperation<Matrix, Integer> subtractFunc = (m1, m2, m3, i, j) -> {
    double value = m1.get(i, j) + m2.get(i, j);
    m3.set(i, j, value);
};
private final static MatrixOperation<Matrix, Integer> productFunc = (m1, m2, m3, i, j) -> {
    double value = 0;
    for (int index = 0; index < m1.column; index++) {
        value += m1.get(i, index) * m2.get(index, j);
    }
    m3.set(i, j, value);
};
//Set number of threads
private final static int threadCount = 4;

public int row, column;
private double[][] matrixElements;


public Matrix(int rows, int columns) {
    this.row = rows;
    this.column = columns;
    matrixElements = new double[row][column];
}


public Matrix(double[][] matrixArray) {
    this.row = matrixArray.length;
    this.column = (matrixArray[0]).length;
    matrixElements = new double[row][column];
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < column; j++) {
            matrixElements[i][j] = matrixArray[i][j];
        }
    }
}

public double get(int i, int j) {
    return matrixElements[i][j];
}

public void set(int i, int j, double value) {
    matrixElements[i][j] = value;
}

private Matrix operation(Matrix m2, Matrix result, MatrixOperation<Matrix, Integer> operator) {
    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    for (int i = 0; i < result.row; i++) {
        for (int j = 0; j < result.column; j++) {
            final int i1 = i;
            final int j1 = j;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    operator.apply(Matrix.this, m2, result, i1, j1);
                }
            });

        }
    }
    try {
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return result;
}

public Matrix add(final Matrix m2) {
    if (this.row != m2.row || this.column != m2.column) {
        throw new IllegalArgumentException();
    }
    return operation(m2, new Matrix(row, column), addFunc);
}

public Matrix subtract(Matrix m2) {
    if (this.row != m2.row || this.column != m2.column) {
        throw new IllegalArgumentException();
    }
    return operation(m2, new Matrix(row, column), subtractFunc);
}


public Matrix dotProduct(Matrix m2) {
    if (this.column != m2.row) {
        throw new IllegalArgumentException();
    }
    return operation(m2, new Matrix(row, m2.column), productFunc);
}

}