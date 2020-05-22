@Fork(5)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class IntStr {
    private int counter;

    @GenerateMicroBenchmark
    public String inlineSideEffect() {
        return new StringBuilder().append(counter++).toString();
    }

    @GenerateMicroBenchmark
    public String spliceSideEffect() {
        int cnt = counter++;
        return new StringBuilder().append(cnt).toString();
    }
}