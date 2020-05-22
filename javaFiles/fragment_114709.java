public class Main extends SimpleBenchmark {
    private static native int zero();
    private Random random;
    private int[] primes;

    public int timeJniCall(int reps) {
        int r = 0;
        for (int i = 0; i < reps; i++) r += Main.zero();
        return r;
    }

    public int timeAddIntOperation(int reps) {
        int p = primes[random.nextInt(1) + 54];   // >= 257
        for (int i = 0; i < reps; i++) p += i;
        return p;
    }

    public long timeAddLongOperation(int reps) {
        long p = primes[random.nextInt(3) + 54];  // >= 257
        long inc = primes[random.nextInt(3) + 4]; // >= 11
        for (int i = 0; i < reps; i++) p += inc;
        return p;
    }

    @Override
    protected void setUp() throws Exception {
        random = new Random();
        primes = getPrimes(1000);
    }

    public static void main(String[] args) {
        Runner.main(Main.class, args);        
    }

    public static int[] getPrimes(int limit) {
        // returns array of primes under $limit, off-topic here
    }

    static {
        System.loadLibrary("foo");
    }
}