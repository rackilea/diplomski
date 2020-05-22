@State(Scope.Benchmark)
public class Dedup {
    private static final HashMap<String, String> HM = new HashMap<>();
    private static final ConcurrentHashMap<String, String> CHM = new ConcurrentHashMap<>();

    private static final int SIZE = 1024 * 1024;
    private static final String[] STRINGS = new Random(0).ints(SIZE)
            .mapToObj(Integer::toString)
            .toArray(String[]::new);

    int idx;

    @Benchmark
    public String intern() {
        String s = nextString();
        return s.intern();
    }

    @Benchmark
    public String hashMap() {
        String s = nextString();
        String prev = HM.putIfAbsent(s, s);
        return prev != null ? prev : s;
    }

    @Benchmark
    public String concurrentHashMap() {
        String s = nextString();
        String prev = CHM.putIfAbsent(s, s);
        return prev != null ? prev : s;
    }

    private String nextString() {
        return STRINGS[++idx & (SIZE - 1)];
    }
}