List<Future<Double>> futures = new ArrayList<>();
for (int i = 0; i < 10; i++) {
    double p1 = Math.pow(2, i);
    for (int j = 5; j < 15; j++) {
        double p2 = Math.pow(2, j);
        Callable<Double> worker = new ProbabilityCalculator(p1, p2);
        futures.add(executor.submit(worker));           
    }
}
// Do whatever else you want to here...

// Now wait for the results and handle them appropriately.
// Note the exceptions that can be thrown...
for (Future<Double> future : futures) {
    double value = future.get();
    ...
}