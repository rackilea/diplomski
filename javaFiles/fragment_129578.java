public void run() {
  while (true) {
    try {
        Logger.info(queue.take());
        //Logger.info(queue.take());
        //Logger.info(queue.take());
    } catch (InterruptedException e) {
        Logger.info(e);
    }
  }
}