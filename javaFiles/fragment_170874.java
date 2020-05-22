@State(Scope.Benchmark)
public class MyBenchmark {

    private List<byte[]> input1k, input10k, input25k, input50k, input100k, input200k;

    @Setup
    public void setUp() {
        input1k = createByteArray(1_000);
        input10k = createByteArray(10_000);
        input25k = createByteArray(25_000);
        input50k = createByteArray(50_000);
        input100k = createByteArray(100_000);
        input200k = createByteArray(200_000);
    }

    private static List<byte[]> createByteArray(int length) {
        Random random = new Random();
        List<byte[]> resultList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            byte[] byteArray = new byte[4096];
            byteArray[random.nextInt(4096)] = 1;
            resultList.add(byteArray);
        }
        return resultList;
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @OperationsPerInvocation(1_000)
    public boolean test1k() {
        return runBenchmark(input1k, this::byteArrayCheck);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @OperationsPerInvocation(10_000)
    public boolean test10k() {
        return runBenchmark(input10k, this::byteArrayCheck);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @OperationsPerInvocation(25_000)
    public boolean test25k() {
        return runBenchmark(input25k, this::byteArrayCheck);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @OperationsPerInvocation(50_000)
    public boolean test50k() {
        return runBenchmark(input50k, this::byteArrayCheck);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @OperationsPerInvocation(100_000)
    public boolean test100k() {
        return runBenchmark(input100k, this::byteArrayCheck);
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @OperationsPerInvocation(200_000)
    public boolean test200k() {
        return runBenchmark(input200k, this::byteArrayCheck);
    }

    private static boolean runBenchmark(List<byte[]> arrays, Predicate<byte[]> method) {
        boolean someUnrelatedResult = false;
        for (byte[] array : arrays) {
            someUnrelatedResult |= method.test(array);
        }
        return someUnrelatedResult;
    }

    private boolean byteArrayCheck(final byte[] array) {
        long sum = 0L;
        for (byte b : array) {
            sum += b;
        }
        return (sum == 0);
    }

    public static void main(String[] args) throws RunnerException {
        new Runner(new OptionsBuilder()
                .include(".*" + MyBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .build()).run();
    }
}