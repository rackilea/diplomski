public final class ServletContextRootRealPath {
  private static String path;

  private ServletContextRootRealPath() {
    // don't instantiate utility classes
  }

  public static void set(String rootRealPath) {
    path = rootRealPath;
  }

  public static String get() {
    return path;
  }
}