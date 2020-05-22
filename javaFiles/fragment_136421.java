@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(5)
public class PrimVsRef {

    @Benchmark
    public void prim() {
        doPrim();
    }

    @Benchmark
    public void ref() {
        doRef();
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private int doPrim() {
        return 42;
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private Object doRef() {
        return this;
    }

}