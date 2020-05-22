private final static int ITERATIONS = 10;
public static void main(String[] args) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < ITERATIONS; ++i) {
        doSort();
    }
    long elapsed = System.currentTimeMillis() - start;
    long average = elapsed / ITERATIONS;
}