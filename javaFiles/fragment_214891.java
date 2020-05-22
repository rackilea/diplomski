public static void dumpThreadStack(final Thread thread) {
  StringBuilder builder = new StringBuilder('\n');
  try {
    for (StackTraceElement element : thread.getStackTrace()) {
      builder.append(element.toString()).append('\n');
    }
  } catch (SecurityException e) { /* ignore */ }
  log.info(builder.toString());
}