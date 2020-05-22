// you can use volatile flag instead if you like
while (!Thread.currentThread.isInterrupted()) {
    try {
        Object item = queue.take();
        // do something with item 
    } catch (InterruptedException e) {
        log.error("Consumer interrupted", e);
        Thread.currentThread().interrupt(); // restore flag
    }
}