Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
for (Thread thread : threadSet) {
  if (thread.getName().startsWith("MyExecutor")) {
  System.out.println(thread.getName() + " " + thread.getState());
    for (StackTraceElement s : thread.getStackTrace()) {
      System.out.println(s);
    }
  }
}