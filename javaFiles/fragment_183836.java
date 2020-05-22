threads[t] = new Thread() {
    @Override
    public void run() {
        totalSum.addAndGet(sumPrimes(seedPrime, new boolean[max - min + 1], min, max));
    }
};