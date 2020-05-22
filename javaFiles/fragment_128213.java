@State(Scope.Benchmark)
public class Streams {
    @Param({"500", "520"})
    int iterations;

    @Setup
    public void init() {
        for (int i = 0; i < iterations; i++) {
            Stream.empty().reduce((x, y) -> x);
        }
    }

    @Benchmark
    public long loop() {
        return Stream.empty().count();
    }
}