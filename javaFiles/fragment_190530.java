// Display a message, preceded by
// the name of the current thread
static void threadMessage(String message) {
    String threadName =
        Thread.currentThread().getName();
    System.out.format("%s: %s%n",
                      threadName,
                      message);
}