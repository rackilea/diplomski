public class RequestContext {

   private static final ThreadLocal<String> contextHolder = 
            new ThreadLocal<String>();

   public static void setRoutingKey(String key) {
      contextHolder.set(key);
   }

   public static String getRoutingKey() {
      return (String) contextHolder.get();
   }

   public static void clearRoutingKey() {
      contextHolder.remove();
   }
}