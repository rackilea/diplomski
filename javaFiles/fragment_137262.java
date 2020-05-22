public static <T> T uncheckCall(Callable<T> callable) {
  try { return callable.call(); }
  catch (Exception e) { return sneakyThrow(e); }
}
public static void uncheckRun(RunnableExc r) {
  try { r.run(); } catch (Exception e) { sneakyThrow(e); }
}
public interface RunnableExc { void run() throws Exception; }


@SuppressWarnings("unchecked")
private static <T extends Throwable> void sneakyThrow(Throwable t) throws T {
  throw (T) t;
}