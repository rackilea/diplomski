public class Vector implements Cloneable {
    // not a good idea to make it public, if you don't want any changes here
    private double[] values;

    public static <T extends Vector> T multiply(T vector, double k) {
        Vector temp = vector.clone();
        for(int i = 0; i < temp.values.length; i++)
            temp.values[i] = k * temp.values[i];
        // the clone method guarantees that 'temp' is of type T,
        // but since it is not generic, the compiler cannot check it
        @SuppressWarnings("unchecked") 
        T result = (T)temp;
        return result;
    }

    protected Vector clone() {
        try {
            Vector vector = (Vector)super.clone();
            vector.values = Arrays.copyOf(values, values.length);
            return vector;
        } catch (final CloneNotSupportedException exc) {
            // this is a weird design choice of `Object.clone()`, too,
            // but back then, we did not have annotations or anything equivalent
            throw new AssertionError("we forgot to implement java.lang.Cloneable", exc);
        }
    }
}