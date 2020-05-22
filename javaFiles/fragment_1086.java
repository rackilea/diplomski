public abstract class SessionUtil {
      private static final ThreadLocal<String> sessionIdThreadLocal = new ThreadLocal<String>();
      public static String getSessionId() {
            return sessionIdThreadLocal.get();
      }
      public static void setSessionId(String jSessionId) {
            sessionIdThreadLocal.set(jSessionId);
      }
      public static void removeSessionId() {
            sessionIdThreadLocal.remove();
      }
}