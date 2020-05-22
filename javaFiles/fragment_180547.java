@PostConstruct
public void init() {
    String cn = "org.apache.logging.log4j.jul.LogManager";
    System.setProperty("java.util.logging.manager", cn);
    LogManager lm = LogManager.getLogManager();
    if (!cn.equals(lm.getClass().getName())) {
       try {
           ClassLoader.getSystemClassLoader().loadClass(cn);
       } catch (ClassNotFoundException cnfe) {
          throw new IllegalStateException("Jars not in system class path.", cnfe);
       }
       throw new IllegalStateException("Found " + lm.getClass().getName() + " set as launch param instead.");
    }
}