LongBinaryOperator op = (v, y) -> {
    try { Thread.sleep(200); } catch (InterruptedException ignored) {}
    long result = (v + y);
    System.out.printf("f(%d, %d) = %d%n", v, y, result);
    return result;
};
LongAccumulator accumulator = new LongAccumulator(op, 1L);

ExecutorService executor = Executors.newFixedThreadPool(2);

Arrays.asList(2, 3, 5, 11, 17, 23, 29, 37, 41, 47).stream()
        .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

executor.shutdown();
executor.awaitTermination(60, TimeUnit.SECONDS);

System.out.println(accumulator.getThenReset());