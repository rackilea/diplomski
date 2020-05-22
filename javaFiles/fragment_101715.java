static void run(String name, Runnable runnable) {
  try {
    runnable.run();
  } catch (Throwable throwable) {
    StackTraceElement[] stackTraceElements = throwable.getStackTrace();
    StackTraceElement[] currentStackTrace = new Throwable().getStackTrace();
    if (stackTraceElements != null && currentStackTrace != null) { // if disabled
      int currentStackSize = currentStackStrace.length;
      int currentFrame = stackTraceElements.length - currentStackSize - 1;
      int methodIndex = name.lastIndexOf('.');
      int argumentIndex = name.indexOf('(');
      stackTraceElements[currentFrame] = new StackTraceElement(
          name.substring(0, methodIndex),
          name.substring(methodIndex + 1, argumentIndex),
          null, // file name is optional
          -1); // line number is optional
      throwable.setStackTrace(stackTraceElements);
    }
    throw throwable;
  }
}