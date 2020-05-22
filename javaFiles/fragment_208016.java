public class Restricted<T> {

    private T value;

    public Restricted(T value) {
        this.value = value;
    }

    public static Restricted<Boolean> getBoolean(Boolean value) {
        return new Restricted<Boolean>(value);
    }

    public static Restricted<Integer> getInteger(Integer value) {
        return new Restricted<Integer>(value);
    }

    public static Restricted<Double> getLong(Double value) {
        return new Restricted<Double>(value);
    }

    // remaining methods omitted
}