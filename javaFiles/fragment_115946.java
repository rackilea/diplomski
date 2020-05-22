// Create a new timer that calls RPC that does nothing.
Timer t = new Timer() {
  @Override
  public void run() {
    //RPC Call 
  }
};

// Schedule the timer to run once in 5 seconds.
t.schedule(5000);