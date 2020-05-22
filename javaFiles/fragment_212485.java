int input = ...;
ExecutorService executor = Executors.newFixedThreadPool(2);
List<Future<Double>> results = executor.invokeAll(Arrays.asList(new MathPowCalculation(input), new FISRCalculation(input)));

for (Future<Double> result : results) {
    Double value = result.get();
    // do something with result value
}

executor.shutdown();