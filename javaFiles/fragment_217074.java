public class HttpSessionListener implements HttpSessionListener {

    private static final AtomicInteger sessionCount = new AtomicInteger(0);

   @Override
   public void sessionCreated(HttpSessionEvent event) {
       sessionCount.incrementAndGet();
   }

   @Override
   public void sessionDestroyed(HttpSessionEvent event) {
       sessionCount.decrementAndGet();
   }

   public static int getTotalSessionCount() {
       return sessionCount.get();
   }

}