try {
   Thread.sleep(1000);
} catch (InterruptedException e) {
   // this is a good pattern otherwise the interrupt bit is cleared by the catch
   Thread.currentThread().interrupt();
   ...
}