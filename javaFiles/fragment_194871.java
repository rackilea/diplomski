class IntArrayWrapper {
    private int[] data = new int[100000];
    void setBoxed(int i, Integer x) { data[i] = x; }
    void setUnboxed(int i, int x) { data[i] = x; }
}

class DoubleArrayWrapper {
    private double[] data = new double[100000];
    void setBoxed(int i, Double x) { data[i] = x; }
    void setUnboxed(int i, double x) { data[i] = x; }
}

@State(Scope.Benchmark)
public class BoxingBenchmarks {
    @Benchmark
    public void intBoxed() {
        final IntArrayWrapper w = new IntArrayWrapper();
        for (int i = 128; i < 100000; i++) w.setBoxed(i, i);
    }

    @Benchmark
    public void intUnboxed() {
        final IntArrayWrapper w = new IntArrayWrapper();
        for (int i = 128; i < 100000; i++) w.setUnboxed(i, i);
    }

    @Benchmark
    public void doubleBoxed() {
        final DoubleArrayWrapper w = new DoubleArrayWrapper();
        for (int i = 0; i < 100000; i++) w.setBoxed(i, (double) i);
    }

    @Benchmark
    public void doubleUnboxed() {
        final DoubleArrayWrapper w = new DoubleArrayWrapper();
        for (int i = 0; i < 100000; i++) w.setUnboxed(i, (double) i);
    }
}