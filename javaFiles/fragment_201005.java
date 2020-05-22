Thread self = Thread.currentThread();
BlockingQueue<String> messages = ...;

while (!self.isInterrupted() || !messages.isEmpty()) {
  try {
    String message = messages.take();
    writeMessage(message);
  } catch (InterruptedException) {
    self.interrupt();
  }
}