public class Matrix<T> {
    public interface Quadrant<T> {
        T get(int i, int j);
        void set(T v, int i, int j);
    }
    public static final int XDIM = 4;
    public static final int YDIM = 4;
    private final Object[][] matrix = new Object[XDIM][YDIM];
    public Matrix() { /* .. */ }
    public Quadrant<T> quadrant(final int x, final int y) {
        return new Quadrant<T> () {
            @SuppressWarnings("unchecked")
            @Override public final T get(int i, int j) {
                return (T) matrix [x+i][y+j]; // todo: range checks, etc.
            }
            @Override public final void set(T v, int i, int j) {
                matrix [x+i][y+j] = v; // todo: range checks, etc.
            }
        };
    }
    public static void main(String[] args) {
        Matrix<Object> m = new Matrix<Object>();
        m.quadrant(2, 2).set("hi there!", 0, 1);
        System.out.format("{%d, %d}:(%d, %d) => %s\n", 2, 2, 0, 1, m.quadrant(2, 2).get(0, 1));
    }
}