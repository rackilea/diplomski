private static final int WARMUP_ITERATIONS = 10000;
private static final int RUN_ITERATIONS = 100000;
public static void main(String[] args) {
    // Warmup with no timing
    for (int i = 0; i < WARMUP_ITERATIONS; ++i) {
        doSort();
    }

    // Now the real test
    long start = System.currentTimeMillis();
    for (int i = 0; i < RUN_ITERATIONS; ++i) {
        doSort();
    }
    long elapsed = System.currentTimeMillis() - start;
    long average = elapsed / RUN_ITERATIONS;
}