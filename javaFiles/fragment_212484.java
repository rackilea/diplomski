public class MathPowCalculation implements Callable<Double> {
    private final int input;

    public MatPowCalculation(int input) {
        this.input = input;
    }

    @Override
    public Double call() throws Exception {
        // your calculation and time measurement and logging
        return result;
    }
}