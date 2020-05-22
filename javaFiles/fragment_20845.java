@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Benchmark {   

    static Integer[] ints = IntStream.range(0, 1_000_000).boxed().toArray(Integer[]::new);

    public static void main(String... args) throws RunnerException {
        Options opt = new OptionsBuilder()
        .include(".*" + Benchmark.class.getSimpleName() + ".*")
        .forks(1)
        .warmupIterations(20)
        .build();

        new Runner(opt).run();
    }

    @GenerateMicroBenchmark
    public void standardForLoop() {
        final String[] arr = new String[ints.length];
        for (int i = 0; i < ints.length; i++) {
            arr[i] = String.valueOf(ints[i]);
        }
    }

    @GenerateMicroBenchmark
    public void forEachLoop() {
        final String[] arr = new String[ints.length];
        for (int i : ints) {
            arr[i] = String.valueOf(i);
        }
    }

    @GenerateMicroBenchmark
    public void streamMapOperation() {
        @SuppressWarnings("unused")
        String[] arr = Arrays.stream(ints).map(String::valueOf).toArray(String[]::new);
    }

    @GenerateMicroBenchmark
    public void streamParallelMapOperation() {
        @SuppressWarnings("unused")
        String[] arr = Arrays.stream(ints).parallel().map(String::valueOf).toArray(String[]::new);
    }    
}