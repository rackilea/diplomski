try {
    callBobsCode();
} catch (RuntimeException e) { // Because Bob is a jerk
    if (e.getCause() instanceOf InterruptedException) {
        // Man, what is that guy's problem?
        interruptCleanlyAndPreserveState();
        // Restoring the interrupt status
        Thread.currentThread().interrupt();
    }
}