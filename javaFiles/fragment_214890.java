log.info("Old security manager = " + System.getSecurityManager());
System.setSecurityManager(new SecurityManager() {
      @Override
      public void checkAccess(final Thread t) {
        StackTraceElement[] list = Thread.currentThread().getStackTrace();
        StackTraceElement element = list[3];
        if (element.getMethodName().equals("interrupt")) {
          log.info("CheckAccess to interrupt(Thread = " + t.getName() + ") - "
                   + element.getMethodName());
          dumpThreadStack(Thread.currentThread());
        }
        super.checkAccess(t);
      }
    });