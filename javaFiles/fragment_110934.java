@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(3)
@State(Scope.Benchmark)
public class IterativeSum {
    @Param({ "100", "10000", "1000000" })
    private int n;

    public static long iterativeSum(long n) {
        long sum = 0;

        for(long i=1; i<=n; i++) {
            sum+=i;
        }
        return sum;
    }

    @Benchmark
    public long is() {
        return iterativeSum(n);
    }
}