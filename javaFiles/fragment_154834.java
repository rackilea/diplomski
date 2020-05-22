import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class Modulo {
    @Param("16")
    int len;

    int i;

    @Benchmark
    public int baseline() {
        return i;
    }

    @Benchmark
    public int conditional() {
        return i = (i + 1 < len) ? i + 1 : 0;
    }

    @Benchmark
    public int mask() {
        return i = (i + 1) & (len - 1);
    }

    @Benchmark
    public int mod() {
        return i = (i + 1) % len;
    }
}