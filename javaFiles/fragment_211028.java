public void runBench(Consumer<String> onAlgorithmCompletion) {
    for (Algorithm a: listOfAlgorithms) {
        double start = System.nanoTime();
        a.run();
        double end = System.nanoTime();
        double result = end - start;
        onAlgorithmCompletion.accept(
                "Algorithm: " + a.getClass().getName() + "\n" +
                "For N = " + a.getN() + " time is: " + result
        );
    }
}