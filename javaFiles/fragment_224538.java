@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
public class Test {

    @Param({"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"})
    public char c;

    @Benchmark
    public char toUpperCaseNormal() {
        return Character.toUpperCase(c);
    }

    @Benchmark
    public char toUpperCaseBitwise() {
        return (char) (c & 65503);
    }
}