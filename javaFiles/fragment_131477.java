public void checkAccess(ThreadGroup g) {
      System.out.println("Access for " + g);
      if ("system".equals(g.getName()))  {
         // will checkPermission java.lang.RuntimePermission "modifyThreadGroup"
         super.checkAccess(g);
      } else {
         throw new SecurityException("Access denied to " + g);
      }
  }

  public void checkAccess(Thread t) {
      System.out.println("Access for " + t);
      if ("SIGTERM handler".equals(t.getName())) {
         // will checkPermission java.lang.RuntimePermission "modifyThread"
         super.checkAccess(t);
      } else {
         throw new SecurityException("Access denied to " + t);
      }
  }