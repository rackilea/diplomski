private void trigger(final Packet packet) {

    executor.execute(new Runnable() {
      @Override
      public void run() {
        // some code here
      }
    });
  }

private final ExecutorService executor = Executors.newFixedThreadPool(10);