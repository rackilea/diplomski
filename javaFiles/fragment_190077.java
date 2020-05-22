public double triangularDistribution(double a, double b, double c) {
    double F = (c - a) / (b - a);
    double rand = Math.random();
    if (rand < F) {
        return a + Math.sqrt(rand * (b - a) * (c - a));
    } else {
        return b - Math.sqrt((1 - rand) * (b - a) * (b - c));
    }
}