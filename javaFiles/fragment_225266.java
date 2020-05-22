try {
   Thread.sleep(1000);
} catch (InterruptedException e) {
   // catching the interrupted exception clears the interrupt flag,
   // so we need to re-enable it
   Thread.currentThread().interrupt();
   // probably you want to stop the thread if it is interrupted
   return;
}