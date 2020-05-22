private static final TDoubleFunction TO_ZERO = new TDoubleFunction() {
    @Override
    public double execute(double value) {
        return 0;
    }
};

public static void zero(TDoubleDoubleHashMap map) {
    map.transformValues(TO_ZERO);
}