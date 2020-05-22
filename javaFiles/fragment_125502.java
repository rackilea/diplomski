@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class JavaBench {

    @Param({"1", "5", "10", "15", "20"})
    int t;

    private int run() {
        int i = 10;
        while(!isEvenlyDivisible(2, i, t))
            i += 2;
        return i;
    }

    private boolean isEvenlyDivisible(int i, int a, int b) {
        if (i > b)
            return true;
        else
            return (a % i == 0) && isEvenlyDivisible(i + 1, a, b);
    }

    @GenerateMicroBenchmark
    public int test() {
        return run();
    }

}