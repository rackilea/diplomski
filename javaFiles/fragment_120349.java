@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Threads(8)
public class SetBenchmark {

    private Set<String> keySetView;
    private Set<String> copyOnWriteArraySet;
    private Random random;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(SetBenchmark.class.getSimpleName())
                                          .warmupIterations(5)
                                          .measurementIterations(5)
                                          .forks(1)
                                          .build();

        new Runner(opt).run();
    }

    @Setup(Level.Iteration)
    public void doSetup() {
        random = new Random(1);
        keySetView = ConcurrentHashMap.newKeySet();
        copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        init(keySetView);
        init(copyOnWriteArraySet);

    }

    private void init(Set<String> set) {
        IntStream.range(0, 100)
                 .forEach(i -> {
                     final String string = String.valueOf((char) i);
                     set.add(string);
                 });

    }


    // Writing
    @Benchmark
    public void _1_keySetView_remove() {
        doRemove(keySetView);
    }

    @Benchmark
    public void _2_copyOnWriteArraySet_remove() {
        doRemove(copyOnWriteArraySet);
    }

    @Benchmark
    public void _3_keySetView_add_with_new_value() {
        doAddWithNewValue(keySetView);
    }

    @Benchmark
    public void _4_copyOnWriteArraySet_add_with_new_value() {
        doAddWithNewValue(copyOnWriteArraySet);
    }

    @Benchmark
    public void _5_keySetView_add_with_existing_value() {
        doAddWithExistingValue(keySetView);
    }

    @Benchmark
    public void _6_copyOnWriteArraySet_add_with_existing_value() {
        doAddWithExistingValue(copyOnWriteArraySet);
    }

    // Reading
    @Benchmark
    public void _7_keySetView_iterate() {
        String res = doIterate(keySetView);
    }

    @Benchmark
    public void _8_copyOnWriteArraySet_iterate() {
        String res = doIterate(copyOnWriteArraySet);
    }

    @Benchmark
    public void _9_keySetView_contains() {
        boolean res = doContains(keySetView);
    }

    @Benchmark
    public void _010_copyOnWriteArraySet_contains() {
        boolean res = doContains(copyOnWriteArraySet);
    }


    // Writing
    private void doRemove(Set<String> set) {
        set.remove(getRandomString());
    }

    private void doAddWithNewValue(Set<String> set) {
        set.add(getRandomString() + set.size());
    }

    private void doAddWithExistingValue(Set<String> set) {
        set.add(getRandomString());
    }

    // Reading
    private String doIterate(Set<String> set) {
        String result = "";
        for (String string : set) {
            result += string;
        }
        return result;
    }

    private boolean doContains(Set<String> set) {
        return set.contains(getRandomString());
    }

    // Random value with seed
    private String getRandomString() {
        return String.valueOf(random.nextInt(100));
    }

}