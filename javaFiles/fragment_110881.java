private final Object lock = new Object();
...
synchronized (lock) {
   if (connected) {
      sendData();
   }
}
...
// this has to wait for the lock to be released before it can be closed
synchronized (lock) {
   if (connected) {
      disconnect();
      connected = false;
   }
}