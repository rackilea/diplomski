private void shutdownThreadpool(int tries) {
    try {
        boolean terminated;
        LOGGER.debug("Trying to shutdown thread pool in {} tries", tries);
        pool.shutdown();
        do {
            terminated = pool.awaitTermination(WAIT_ON_SHUTDOWN,TimeUnit.MILLISECONDS);
            if (--tries == 0
                    && !terminated) {
                LOGGER.debug("After 10 attempts couldn't shutdown thread pool, force shutdown");
                pool.shutdownNow();
                terminated = pool.awaitTermination(WAIT_ON_SHUTDOWN, TimeUnit.MILLISECONDS);
                if (!terminated) {
                    LOGGER.debug("Cannot stop thread pool even with force");
                    LOGGER.trace("Some of the workers doesn't react to Interruption event properly");
                    terminated = true;
                }
            } else {
                LOGGER.info("After {} attempts doesn't stop", tries);
            }
        } while (!terminated);
        LOGGER.debug("Successfully stop thread pool");
    } catch (final InterruptedException ie) {
        LOGGER.warn("Thread pool shutdown interrupted");
    }
}