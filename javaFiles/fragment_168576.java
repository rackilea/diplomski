Runnable runnable = new Runnable() {
    public void run() {
      // wait(); This call wouldn't work
      syncronized (this) {
        wait();  // This call will work
      }
    }
};