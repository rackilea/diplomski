class Channel implements MessageReceiver {
  BlockingQueue q=new ArrayBlockingQueue();

  public void messageReceived(Message m) {
     q.put(m);
  }

  public Message getNextMessage() {
    return q.take();
  }
}