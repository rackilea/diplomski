public static synchronized GraphicsEnvironment getLocalGraphicsEnvironment() {
          if (localEnv == null) {
               // Y O U R   E R R O R  O R I G I N A T E S    H E R E !!! 
              String nm = (String) java.security.AccessController.doPrivileged
                  (new sun.security.action.GetPropertyAction
                   ("java.awt.graphicsenv", null));

              try {
  //                      long t0 = System.currentTimeMillis();
                  localEnv =
                      (GraphicsEnvironment) Class.forName(nm).newInstance();
  //              long t1 = System.currentTimeMillis();
  //              System.out.println("GE creation took " + (t1-t0)+ "ms.");
                  if (isHeadless()) {
                      localEnv = new HeadlessGraphicsEnvironment(localEnv);
                  }
              } catch (ClassNotFoundException e) {
                  throw new Error("Could not find class: "+nm);
              } catch (InstantiationException e) {
                  throw new Error("Could not instantiate Graphics Environment: "
                                  + nm);
              } catch (IllegalAccessException e) {
                  throw new Error ("Could not access Graphics Environment: "
                                   + nm);
              }
          }

          return localEnv;
      }