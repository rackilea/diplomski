StackTraceElement caller = Thread.currentThread().getStackTrace()[1];

caller.getClassName();
caller.getMethodName();
caller.getFileName();
caller.getLineNumber();