public class Runtimeconfig {
    public static void main(String args[]) {
        System.setProperty(XMLConfigurationFactory.CONFIGURATION_FILE_PROPERTY, "/home/peter/config/log4j2.xml");
        new LoggedClass().logMe();
    }
}


public class LoggedClass {
    static Logger logger = LogManager.getLogger(LoggedClass.class);

    public void logMe() {
        logger.info("I'm logged!");
    }
}