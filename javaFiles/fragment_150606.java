for (int i = 0; i < 3; i++) {
    long start = System.currentTimeMillis();
    IntStream.range(0, 100).parallel()
            .forEach(ele -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            });
    long time = System.currentTimeMillis() - start;
    System.out.printf("Took %,d ms to perform 100 tasks of 100 ms on %d processors%n",
            time, Runtime.getRuntime().availableProcessors());
}