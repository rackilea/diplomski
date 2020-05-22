interface F3 extends ToDoubleFunction<double[]> {
    double apply(double a0, double a1, double a2);
    default double applyAsDouble(double[] a) {
        return apply(a[0], a[1], a[2]);
    }
}