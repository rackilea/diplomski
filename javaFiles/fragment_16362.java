public abstract class SimEnum<T> implements Face<T> {
    public static final SimEnum<Number> A = new SimEnum<Number>() {
        @Override
        public List<Number> get() { return ...; }
    };
    public static final SimEnum<String> B = new SimEnum<String>() {
        @Override
        public List<String> get() { return ...; }
    };

    private SimEnum() {}

    public static SumEnum<?>[] values() {
        return new SimEnum<?>[] { A, B };
    }
}