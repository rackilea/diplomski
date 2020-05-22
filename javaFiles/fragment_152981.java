public class SimpleCalcBenchmark {
    static int n = 10000;
    static final AtomicLong blackHole = new AtomicLong();

    public static void main(String[] args) throws RunnerException, IOException {
        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            long counter = 0;
            while (System.nanoTime() - start < 2e9) {
                for (int j = 0; j < 100; j++) {
                    blackHole.lazySet(calc());
                }
                counter += 100;
            }
            long time = System.nanoTime() - start;
            System.out.printf("Took an average of %.1f ns%n", (double) time/counter);
        }
    }

    public static long calc() {
        return (n - 1L) * n / 2 * (n + 1) / 3 * (3 * n + 2) / 2;
    }
}