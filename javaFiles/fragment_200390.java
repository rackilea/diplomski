private static double sqrt2(long number, int maxIterations, double x, int itr, double epsilon)
        throws MaxIterationsReachedException {
    double x1 = (x + (number / x)) / 2;
    while (Math.abs(x1 - x) > epsilon) {
        if (itr >= maxIterations) {
            throw new MaxIterationsReachedException(maxIterations);
        }
        x = x1;
        x1 = (x + (number / x)) / 2;
        itr++;
    }
    System.out.println("Total Iterations - " + itr);
    return x1;
}