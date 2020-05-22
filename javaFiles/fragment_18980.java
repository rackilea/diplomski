try {
    // Some code that might throw an InterruptedException.  
    // Using sleep as an example
    Thread.sleep(10000);
} catch (InterruptedException ie) {
    System.err.println("Interrupted in our long run.  Stopping.");
    Thread.currentThread().interrupt();
}