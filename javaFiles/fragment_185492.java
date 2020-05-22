public class Matrix {
    private int[][] backingArray;
    private boolean transposed;
    public Matrix(int[][] _backingArray) {
        this.backingArray = _backingArray
    }

    public Matrix(int[] data, rows, columns) {
        backingArray = new int[rows][columns]
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                backingArray[i][j] = data[i*columns + j]
    }

    public int getElement(i, j) {
        if (transposed)
            return backingArray[j][i];
        return backingArray[i][j];
    }

    public void transpose() {
        transpose = !transpose;
    }
}