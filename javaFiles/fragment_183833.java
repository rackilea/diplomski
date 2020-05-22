public static long sumPrimes(int n, int threadCount) {
    // Find and sum the "seed" primes needed by the threads
    int maxSeedPrime = (int) Math.sqrt(n + 2); // extra to be sure no "float errors" occur
    boolean[] seedPrime = new boolean[maxSeedPrime + 1];
    AtomicLong totalSum = new AtomicLong(sumPrimes(seedPrime, seedPrime, 0, maxSeedPrime));

    // Split remaining into ranges and start threads to calculate sums
    Thread[] threads = new Thread[threadCount];
    for (int t = 0, rangeMin = maxSeedPrime + 1; t < threadCount; t++) {
        int min = rangeMin;
        int max = min + (n - min + 1) / (threadCount - t) - 1;
        threads[t] = new Thread(() ->
            totalSum.addAndGet(sumPrimes(seedPrime, new boolean[max - min + 1], min, max))
        );
        threads[t].start();
        rangeMin = max + 1;
    }

    // Wait for threads to end
    for (int t = 0; t < threadCount; t++) {
        try {
            threads[t].join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Return the calculated sum
    return totalSum.get();
}