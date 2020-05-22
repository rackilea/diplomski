public class LogFactory {

public static final String TOOLKIT = "logging.toolkit";
public static final String TOOLKITCLASS = "logging.toolkit.class";
public static final String Log4j = "log4j";

public static LogAdapter logAdapter;
public static Object lock = new Object();

/**
 * Get specific Log implementation
 * @param name
 * @return
 */
public static Log getLog(final String name) {

    if (logAdapter == null) {   

        synchronized (lock) {

            String toolkitClass = System.getProperty(TOOLKITCLASS);

            if (toolkitClass != null) {
                System.out.println("\n Logging toolkitClass:" + toolkitClass + "\n\n");
                logAdapter = createObject(toolkitClass);
            } 
            else {
                String toolkit = System.getProperty(TOOLKIT);
                if (toolkit == null) {
                    toolkit = Log4j;
                }
                if (toolkit.equalsIgnoreCase(Log4j)) {
                    logAdapter = new Log4jAdapter();
                }
            }

            //Initialize adapter
            logAdapter.init();
        }
    }

    return logAdapter.getLog(name);
}


public static Log getLog(final Class<?> clazz) {

    return LogFactory.getLog(clazz.getName());
}


/**
 * Create an instance of wrapper class using reflection
 * @param className
 * @return
 */
private static LogAdapter createObject(final String className) {

   Object o = null;

   try {
       Class<?> cl = Class.forName(className);
       Constructor<?> c = cl.getConstructor();
       o = c.newInstance();
   } 
   catch (Exception e) {
       e.printStackTrace();
   }
   return (LogAdapter) o;
}   

}