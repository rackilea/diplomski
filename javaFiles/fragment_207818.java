new Thread(new Runnable() {
  // some code here ...

  // This might be in a loop.
  try {
    Thread.sleep(2000);
  } catch(InterruptedException ex) {
    // Handle ...
  }
 }
}).start();