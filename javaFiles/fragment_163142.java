@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(BCElimination.N)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@State(Scope.Thread)
@Threads(1)
@Fork(2)
public class BCElimination {
    public static final int N = 1024;
    private static final Unsafe U;
    private static final long INT_BASE;
    private static final long INT_SCALE;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            U = (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        INT_BASE = U.arrayBaseOffset(int[].class);
        INT_SCALE = U.arrayIndexScale(int[].class);
    }

    private final int[] table = new int[BCElimination.N];

    @Setup public void setUp() {
        final Random random = new Random();
        for (int i=0; i<table.length; ++i) table[i] = random.nextInt();
    }

    @GenerateMicroBenchmark public int normalIndex() {
        int result = 0;
        final int[] table = this.table;
        int x = 0;
        for (int i=0; i<=table.length-1; ++i) {
            x += i;
            final int j = x & (table.length-1);
            result ^= table[i] + j;
        }
        return result;
    }

    @GenerateMicroBenchmark public int maskedIndex() {
        int result = 0;
        final int[] table = this.table;
        int x = 0;
        for (int i=0; i<=table.length-1; ++i) {
            x += i;
            final int j = x & (table.length-1);
            result ^= i + table[j];
        }
        return result;
    }

    @GenerateMicroBenchmark public int maskedIndexUnsafe() {
        int result = 0;
        final int[] table = this.table;
        long x = 0;
        for (int i=0; i<=table.length-1; ++i) {
            x += i * INT_SCALE;
            final long j = x & ((table.length-1) * INT_SCALE);
            result ^= i + U.getInt(table, INT_BASE + j);
        }
        return result;
    }
}