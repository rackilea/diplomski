class RateLimitedRunnable implements Runnable {
    Runnable runnable;
    RateLimitedRunnable(Runnable r) { runnable = r; }
    void Run() {
        semaphore.acquire();
        runnable.run();
        semaphore.release(); // remove if only limiting starts
    }
}