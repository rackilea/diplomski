try {
    ...
} catch (InterruptedException e) {
    // InterruptedException clears interrupt flag
    // I always re-interrupt the thread first
    Thread.currentThread().interrupt();
    // then i decide if I want the thread to return or throw or ...
    return;
}