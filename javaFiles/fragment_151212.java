private static final String SHUTDOWN = new String("SHUTDOWN"); // use new String() so you don't get an interned value

public void readQueue() {
  while ((data = (String)MyLinkedBlockingQueue.take()) != SHUTDOWN) {
      //read and live 
  }
}

public void shutdownQueue() {
  MyLinkedBlockingQueue.put(SHUTDOWN);
}