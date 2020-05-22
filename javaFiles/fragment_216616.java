public synchronized void stop(long stopInterval) throws Exception {
    if (running == false) {
        throw new IllegalStateException("Monitor is not running");
    }
    running = false;
    try {
        thread.join(stopInterval);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    /***** Observers are destroyed here ****/
    for (FileAlterationObserver observer : observers) {
        observer.destroy();
    }
}