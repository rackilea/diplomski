// create queue, max size 100
final ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(100);
final String stop = "STOP";

// start producing
Runnable producer = new Runnable() {
  @Override
  public void run() {
    try {
      for(int i = 0; i < 1000; i++) {
        strings.put(Integer.toHexString(i));
      }
      strings.put(stop);
    } catch(InterruptedException ignore) {
    }
  }
};

Thread producerThread = new Thread(producer);
producerThread.start();

// start monitoring
Runnable monitor = new Runnable() {
  @Override
  public void run() {
    try {
      while (true){
        System.out.println("Queue size: " + strings.size());
        Thread.sleep(5);
      }
    } catch(InterruptedException ignore) {
    }
  }
};
Thread monitorThread = new Thread(monitor);
monitorThread.start();

// start consuming
Runnable consumer = new Runnable() {
  @Override
  public void run() {
    // infinite look, will interrupt thread when complete
    try {
      while(true) {
        String value = strings.take();
        if(value.equals(stop)){
          return;
        }
        System.out.println(value);
      }
    } catch(InterruptedException ignore) {
    }
  }
};

Thread consumerThread = new Thread(consumer);
consumerThread.start();

// wait for producer to finish
producerThread.join();
consumerThread.join();

// interrupt consumer and monitor
monitorThread.interrupt();