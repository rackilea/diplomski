try {
     Thread.sleep(...);
 } catch (InterruptedException e) {
     // always good practice because catching the exception clears the flag
     Thread.currentThread().interrupt();
     // most likely we should stop the thread if we are interrupted
     return;
 }