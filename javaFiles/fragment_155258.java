@GenerateMicroBenchmark(BenchmarkType.AverageTimePerOp)
public Map getDeclaredFields() {
    Map m = new HashMap(ThisClass.class.getDeclaredFields().length, 1.0f);
    for (int i = 0; i < 9; i++) {
        m.put(i, "a");
    }
    return m;
}

@GenerateMicroBenchmark(BenchmarkType.AverageTimePerOp)
public Map resize() {
    Map m = new HashMap(8, 0.75f);
    for (int i = 0; i < 9; i++) {
        m.put(i, "a");
    }
    return m;
}

class ThisClass {
    private int i, j, k;
    public String s, t, u;
    protected List l, m, n;
}