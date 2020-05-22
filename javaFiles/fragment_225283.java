public YourConstructor() {
     ....
     StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
     int depth = 1;   // Check for different depths is necessary.
     System.out.println(stackTraceElements[depth].getClassName());
     ...
}