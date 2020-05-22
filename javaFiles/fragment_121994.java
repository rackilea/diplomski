@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(batchSize = 10000, iterations = 10)
@Warmup(batchSize = 10000, iterations = 10)
@Fork(1)
public class StringConcatenationBenchmark {
    private static final String S = "some more data";
    private static final int maxLen = S.length()*10000;

    private String string;

    private StringBuilder stringBuilder;

    @Setup(Level.Iteration)
    public void setup() {
        string = "";
        stringBuilder = new StringBuilder();
    }

    @Benchmark
    public void stringConcatenation() {
        if(string.length() >= maxLen) string = "";
        string += S;
    }

    @Benchmark
    public void stringBuilderConcatenation() {
        if(stringBuilder.length() >= maxLen) stringBuilder = new StringBuilder();
        stringBuilder.append(S);
    }
}