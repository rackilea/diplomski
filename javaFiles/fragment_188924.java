/**
 * Blocks until all tasks have completed execution after a shutdown
 * request, or the timeout occurs, or the current thread is
 * interrupted, whichever happens first.
 */
boolean awaitTermination(long timeout, TimeUnit unit)
    throws InterruptedException;