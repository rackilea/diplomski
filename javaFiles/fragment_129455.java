private double generateValue(final double lastValue, final double factor) {
    final double result = lastValue * factor;
    if (result <= 0.0 || result >= 300.0) {
        return 100.00;
    }
    return result;
}