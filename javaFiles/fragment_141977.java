try {
    ...wait();
} catch (InterruptedException ie) {
    Thread.currentThread().interrupt();
    // handle the interrupt
    return;
}