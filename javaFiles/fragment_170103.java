// Show printStackTrace() output
new RuntimeException().printStackTrace(System.out);

// Similar output using getStackTrace()
StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
System.out.println("getStackTrace()");
for (int i = 1; i < stackTrace.length; i++)
    System.out.println("\tat " + stackTrace[i]);