volatile boolean shouldSleep = false;
 ...
 // check this flag that might be set by another thread to see if I should sleep
 if (shouldSleep) {
     Thread.sleep(...);
 }