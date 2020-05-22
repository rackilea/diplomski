private final Semaphore sema = new Semaphore(1, true); // binary: only 1 permit
....
try {
    sema.acquire();   // blocks till permit is available
    try {
        // critical section code
        ....
    } finally {
        sema.release();   // release permit
    }
} catch (InterruptedException ie) {
    ....