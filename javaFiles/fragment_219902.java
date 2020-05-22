public static void main(String args) throws Exception {
    // Note that the number of threads is now specified here
    ExecutorService pool = Executors.newFixedThreadPool(5);
    ResultCalculator calc = new ResultCalculator(pool);
    try {
        calc.startComputation();
        // Maybe do something while we're waiting
        System.out.printf("Result is: %d\n", calc.getFinalResult());
    } finally {
        pool.shutdownNow();
    }
}