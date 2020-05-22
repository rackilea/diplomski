@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
public class MyBenchmark {

    @Param({"10", "100", "1000", "10000", "100000"})
    private int size;

    private List<String> finalWords;

    @Setup(Level.Invocation)
    public void initialize() {
        finalWords = IntStream.range(0, size)
                              .mapToObj(i -> {
                                  return ThreadLocalRandom.current()
                                                          .ints(10, 'a', 'z' + 1)
                                                          .mapToObj(c -> Character.toString((char) c))
                                                          .collect(Collectors.joining());
                              }).collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public String stringBuilder() {
        StringBuilder sb = new StringBuilder();
        finalWords.forEach(word -> sb.append(word).append(","));
        return sb.toString();
    }

    @Benchmark
    public String stream() {
        return finalWords.stream().collect(Collectors.joining(","));
    }
}