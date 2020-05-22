final ConcurrentLinkedQueue<MyMessageClass> messages = new ConcurrentLinkedQueue<MyMessageClass>();

public void addMessage(final MyMessageClass message) {
  messaged.add(message);
}

protected void serverLoop() {
  //...
  final MyMessageClass message = messages.poll(); // does not block, returns null if none is available
  if (message != null) {
    handleMessage(message);
  }
  //...
}