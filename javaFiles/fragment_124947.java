@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Increments {

    private long[] primes;

    @Setup
    public void setup() {
        primes = new long[] {3, 5, 7, 11, 13, 17, 19, 23};
    }

    @Benchmark
    @Fork(1)
    public List<Integer> inc() {
        List<Integer> answers = new ArrayList<>();
        for (int i = 3; i < 100; i++) {
            int bit = i % 32;
            int cur = i / 32;
            long test = (primes[cur] >> bit) & 1;
            if (test == 1) {
                answers.add(i);
            }
        }
        return answers;
    }

    @Benchmark
    @Fork(1)
    public List<Integer> addOne() {
        List<Integer> answers = new ArrayList<>();
        for (int i = 3; i < 100; i+=1) {
            int bit = i % 32;
            int cur = i / 32;
            long test = (primes[cur] >> bit) & 1;
            if (test == 1) {
                answers.add(i);
            }
        }
        return answers;
    }

    @Benchmark
    @Fork(1)
    public List<Integer> addTwo() {
        List<Integer> answers = new ArrayList<>();
        for (int i = 3; i < 100; i+=2) {
            int bit = i % 32;
            int cur = i / 32;
            long test = (primes[cur] >> bit) & 1;
            if (test == 1) {
                answers.add(i);
            }
        }
        return answers;
    }
}