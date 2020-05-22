@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime) 
    @OutputTimeUnit(TimeUnit.NANOSECONDS) 
    @Warmup(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)   
    @Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS) 
    @State(Scope.Thread) public class GuavaTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(GuavaTest.class.getSimpleName())
                .jvmArgs("-ea", "-Xms10g", "-Xmx10g")
                .shouldFailOnError(true)
                .build();
        new Runner(opt).run();
    }

    @Param(value = { "300", "1000" })
    public String tokenToSearchFor;

    @State(Scope.Benchmark)
    public static class ThreadState {
        String longString = IntStream.range(1, 20000).boxed().map(Object::toString).collect(Collectors.joining(" ,"));

        StringTokenizer st = null;

        Pattern pattern = null;

        Splitter splitter = null;

        @Setup(Level.Invocation)
        public void setUp() {
            st = new StringTokenizer(longString, ",", false);
            pattern = Pattern.compile(",");
            splitter = Splitter.on(',').trimResults();
        }
    }

    @Benchmark
    @Fork(1)
    public boolean doWithStringTokenizer(ThreadState ts) {
        while (ts.st.hasMoreTokens()) {
            String t = ts.st.nextToken().trim();
            if (t.equals(tokenToSearchFor)) {
                return true;
            }
        }
        return false;
    }

    @Benchmark
    @Fork(1)
    public boolean doWithRegex(ThreadState ts) {
        return ts.pattern.splitAsStream(ts.longString)
                .map(String::trim)
                .anyMatch(tokenToSearchFor::equals);
    }

    @Benchmark
    @Fork(1)
    public boolean doWithGuava(ThreadState ts) {
        Iterable<String> iterable = ts.splitter.split(ts.longString);
        for (String s : iterable) {
            if (s.equals(tokenToSearchFor)) {
                return true;
            }
        }
        return false;
    }

}