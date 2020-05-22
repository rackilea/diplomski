// nrPermits is the number of simultaneous semaphore holders
final Semaphore semaphore = new Semaphore(nrPermits);

// then:

semaphore.acquire(); // blocks until a permit is available
try {
    criticalSection();
} finally {
    semaphore.release();
}