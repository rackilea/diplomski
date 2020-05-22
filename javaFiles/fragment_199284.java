synchronized (Shutdown.class) {
     /* Synchronize on the class object, causing any other thread
      * that attempts to initiate shutdown to stall indefinitely
      */
     sequence();
     halt(status);
}