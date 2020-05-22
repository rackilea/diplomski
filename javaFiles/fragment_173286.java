class Consumer implements Runnable {
  private List itemsToProcess = new ArrayList();
  run() {
        while (true) { // or when producers are stopped and queue is empty
          while (itemsToPorcess.size() < X) {
            itemsToProcess.add(sharedQueue.take());
          }
          // do process
          itemsToProcess.clear();
        }
  }
}