public double getParallelResistance() {
    double sum;
    for (double r : resistance) {
        sum += 1 / r;
    }
    return 1 / sum;
}

private double getSeriesResistance() {
    double sum;
    for (double r : resistance) {
        sum += r;
    }
    return sum;
}