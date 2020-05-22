import org.apache.log4j.Logger;
    public class LoggerUtils {

        private static Logger log = null;

        // Static initializer loads only once when the class loads into memory
        static {
            System.out.println("Inside LoggerUtils static block");
            log = Logger.getLogger(LoggerUtils.class);
            System.out.println("LoggerUtils Class Name == "
                    + LoggerUtils.log.getClass().getName());
        }// end of static block

        /**
         * Default no argument constructor
         */
        public LoggerUtils() {
        }

        /**
         * @param String, debug statement to log.
         */
        public static void debug(String logString) {
            log.debug(logString);
        }

        /**
         * @param String, info statement to log.
         */
        public static void info(String logString) {
            log.info(logString);
        }

        /**
         * @param String, error statement to log.
         */
        public static void error(String logString) {
            log.error(logString);
        }

        /**
         * @param String, warning statement to log.
         */
        public static void warn(String logString) {
            log.warn(logString);
        }



        /**
         * @param logString, error message to log.
         * @param e, error object.
         */
        public static void error(String logString, Exception e) {

            error(logString);

            if (e != null) {

                StackTraceElement[] elements = null;
                elements = e.getStackTrace();

                if (elements != null) {
                    StringBuffer strBuffer = new StringBuffer("");
                    for (int i = 0; i < elements.length; i++) {
                        strBuffer.append(elements[i]).append("\n");
                    }

                    error("Stack Trace :: \n" + strBuffer.toString());
                    strBuffer = null;
                }

                elements = null;

            }// end of if(e != null)

        }

        /**
         * @param logString, error message to log.
         * @param messages, messageObject to log.
         */
        public static void error(String logString, Object[] messages) {
            error(logString);

            if (messages != null) {

                StringBuffer strBuffer = new StringBuffer("");
                for (int i = 0; i < messages.length; i++) {
                    strBuffer.append(messages[i]).append("\n");
                }
                error(strBuffer.toString());
                strBuffer = null;

            }// end of if(messages != null)

        }

        /**
         * @param logString, fatal message to log.
         */
        public static void fatal(String logString) {
            log.fatal(logString);
        }

    }// end of class - LoggerUtils