try {
    ...
} catch (InterruptedException ie) {
    // re-interrupt the thread now that we've caught InterruptedException
    Thread.currentThread().interrupt();
    // probably quit the thread
    return;
}