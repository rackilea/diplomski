try {
    ...
} catch (InterruptedException ie) {
    // re-enable interrupt bit since catching InterruptedException clears it
    Thread.currentThread().interrupt();
    // handle the interrupt by maybe quitting the thread
    return;
}