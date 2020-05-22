public class ProbabilityCalculator implements Callable<ProbabilityResult> {
    private final double p1, p2;

    public ProbabilityCalculator(double p1, double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public ProbabilityResult call() {
        double probabilty = ...;
        return new ProbabilityResult(p1, p2, probability);
    }
}