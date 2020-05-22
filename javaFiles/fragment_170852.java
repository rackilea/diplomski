Timer t = new Timer() {
      public void run() {
        Window.alert("Nifty, eh?");
        // your messageBox code
        t.cancel(); // Since you only need this run once.
      }
    };

    // Schedule the timer to run once in 2 seconds.
    t.schedule(2000);