public synchronized void run() {
    int count = 0;
    try {
      // token initializes false
      // wait until notification on button press
      synchronized (token) {
        token.wait();
      }

      // outer loop
      while (true) {
        // inner loop runs as long as token value is true
        // will change to false on button press
        while (token.running()) {
          lbq.put(count);
          System.out.println("queue size = " + lbq.size());
          count++;
          sleep(100);
        }

        // wait until notification on button press, again      
        synchronized (token) {
          token.wait();
        }
      }
    } catch (InterruptedException e2) {
      e2.printStackTrace();
    }
  }