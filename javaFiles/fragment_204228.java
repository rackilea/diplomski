import java.util.function.BinaryOperator;

public class Test {
    private static void test(String desc, BinaryOperator<Double> op, double a, double b, long startIter)
    {
        long maxIter = startIter;
        long elapsed;
        do {
            maxIter *= 2;
            long start = System.currentTimeMillis();
            for (long niter = 0; niter < maxIter; ++niter) {
                double res = op.apply(a, b);
            }
            elapsed = System.currentTimeMillis() - start;
        } while (elapsed <= 10_000);
        System.out.printf("%-15s/sec\t%g\n",
            desc, (maxIter * 1000.0) / elapsed);
    }

    public static void main(String[] arg)
    {
        test("Addition (double)", (Double a, Double b) -> {
            return a + b;
        }, 483902.7743, 42347.775, 10_000_000);
        test("Subtraction (double)", (Double a, Double b) -> {
            return a - b;
        }, 483902.7743, 42347.775, 10_000_000);
        test("Multiplication (double)", (Double a, Double b) -> {
            return a * b;
        }, 483902.7743, 42347.775, 1_000_000);
        test("Division (double)", (Double a, Double b) -> {
            return a / b;
        }, 483902.7743, 42347.775, 1_000_000);
        test("Log10", (Double a, Double b) -> {
            return Math.log10(a);
        }, 483902.7743, 42347.775, 1_000_000);
        test("LogE", (Double a, Double b) -> {
            return Math.log(a);
        }, 483902.7743, 42347.775, 1_000_000);
        test("Power", (Double a, Double b) -> {
            return Math.pow(a, b);
        }, 483902.7743, 12, 100_000);
    }
}