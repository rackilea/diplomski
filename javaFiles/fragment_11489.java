package bench;

import org.openjdk.jmh.annotations.*;
import java.awt.geom.RoundRectangle2D;

@State(Scope.Benchmark)
public class StaticRect {
    private static final RoundRectangle2D.Double RECTANGLE =
            new RoundRectangle2D.Double(1, 2, 3, 4, 5, 6);

    @Benchmark
    public long baseline() {
        return 0;
    }

    @Benchmark
    public long testNew() {
        return new RoundRectangle2D.Double(1, 2, 3, 4, 5, 6).hashCode();
    }

    @Benchmark
    @Fork(jvmArgs = "-XX:-EliminateAllocations")
    public long testNewNoEliminate() {
        return new RoundRectangle2D.Double(1, 2, 3, 4, 5, 6).hashCode();
    }

    @Benchmark
    public int testStatic() {
        return RECTANGLE.hashCode();
    }
}