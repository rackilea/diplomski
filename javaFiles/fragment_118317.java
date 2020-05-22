public abstract class Benchmark {

    public static void main(String[] args) throws Exception {
        final ThreadLocal<DecimalFormat> restrictTo1DecimalPlace =
                ThreadLocal.withInitial
                        (() -> new DecimalFormat("0.0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH)));            
        Benchmark[] marks = {
            new Benchmark("ThreadLocal") {
                @Override
                protected Object run(int iterations) throws Throwable {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < iterations; i++) {
                        sb.append(restrictTo1DecimalPlace.get().format(i * 0.01));
                    }
                    return sb;
                };
            },
            new Benchmark("new Format") {
                @Override
                protected Object run(int iterations) throws Throwable {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < iterations; i++) {
                        sb.append(new DecimalFormat("0.0%", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(i * 0.01));
                    }
                    return sb;
                };
            },
        };
        for (Benchmark mark : marks) {
            System.out.println(mark);
        }
    }

    final String name;

    public Benchmark(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\t" + time() + " ns / iteration";
    }

    private BigDecimal time() {
        try {
            // automatically detect a reasonable iteration count (and trigger just in time compilation of the code under test)
            int iterations;
            long duration = 0;
            for (iterations = 1; iterations < 1_000_000_000 && duration < 1_000_000_000; iterations *= 2) {
                long start = System.nanoTime();
                run(iterations);
                duration = System.nanoTime() - start;
            }
            return new BigDecimal((duration) * 1000 / iterations).movePointLeft(3);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes the code under test.
     * @param iterations
     *            number of iterations to perform
     * @return any value that requires the entire code to be executed (to
     *         prevent dead code elimination by the just in time compiler)
     * @throws Throwable
     *             if the test could not complete successfully
     */
    protected abstract Object run(int iterations) throws Throwable;
}