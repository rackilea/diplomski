public void addMessage(String message) {
  if (thread.isInterrupted() || !thread.isAlive()) {
    throw new IllegalStateException();
  }
  messages.add(message);
}