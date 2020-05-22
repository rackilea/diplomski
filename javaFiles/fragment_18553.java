private final Semaphore available = new Semaphore(MAX_COUNT, true);

public void InternalPow(double a, double b) {
    available.aquire();
    try {
        // Code here
    } finally {
        available.release();
    }
}