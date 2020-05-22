public class threadLocal {
 private static ThreadLocal<String> myThreadLocal = new ThreadLocal<String>();

 public static String getMyThreadLocal() {
    return myThreadLocal.get();
  }

 public static void setMyThreadLocal(String str) {
    myThreadLocal.set(str);
  }
}