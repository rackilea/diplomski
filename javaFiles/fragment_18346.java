public class Parameter<T extends Number & Comparable<T>> {
    public final T min;
    public final T max;
    private T value;

    public Parameter(T min, T max, T current) {
        this.min = min; 
        this.max = max; 
        setValue(current); // Use setter to check range on construction 
    }

    public void setValue(T v) {
        // being Comparable, we can check the range generically
        if (max.compareTo(v) < 0) { 
            throw new IllegalArgumentException("Value exceeds " + max);
        }
        if (min.compareTo(v) > 0) {
            throw new IllegalArgumentException("Value is below " + min);
        }

        this.value = v;
    }

    public T getValue() {
        return this.value;
    }
}