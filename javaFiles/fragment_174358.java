public class SparseMatrix<T> {
    private T defaultValue;
    private int m;
    private int n;
    private Map<Integer, T> data = new TreeMap<Integer, T>();
    /// create a new matrix with m rows and n columns
    public SparseMatrix(int m, int n, T defaultValue) {
        this.m = m;
        this.n = n;
        this.defaultValue = defaultValue;
    }
    /// set value at [i,j] (row, col)
    public void setValueAt(int i, int j, T value) {
        if (i >= m || j >= n || i < 0 || j < 0) 
            throw new IllegalArgumentException(
                    "index (" + i + ", " +j +") out of bounds");        
        data.put(i * n + j, value);
    }
    /// retrieve value at [i,j] (row, col)
    public T getValueAt(int i, int j) {
        if (i >= m || j >= n || i < 0 || j < 0) 
            throw new IllegalArgumentException(
                    "index (" + i + ", " +j +") out of bounds");
        T value = data.get(i * n + j);
        return value != null ? value : defaultValue;
    }
}