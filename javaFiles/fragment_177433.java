synchronized (this) {
   while (conditionForWaiting) {
      try {
         wait();
      } catch (InterruptedException ex) {}

}
performWork();