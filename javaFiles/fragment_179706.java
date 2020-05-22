public static class ResourceProcessor implements Runnable {
   private final int resource;
   public ResourceProcessor(int resource) {
      this.resource = resource;
   }
   public void run() {
      try {
         // does some work
      } finally {
         // if this is still necessary then you should use a `Future` instead
         incrementProcessedResources();
      }
   }
}