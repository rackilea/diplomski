public class Runtimeconfig {

    static {
        System.setProperty(XMLConfigurationFactory.CONFIGURATION_FILE_PROPERTY, "/home/peter/config/log4j2.xml");
    }

    static Logger logger = LogManager.getLogger(Runtimeconfig.class);

    public static void main(String args[]) {

        new LoggedClass().logMe();
        new Runtimeconfig().logger.info("I'm logged too");
    }
}