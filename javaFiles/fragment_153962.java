public class YourClass{
Logger logger = Logger.getLogger(YourClass.class);
SimpleLayout layout = new SimpleLayout();
FileAppender appender = null;

public YourClass() {
    try {
        appender = new FileAppender(layout, "/path/tolog/yourUniqueId.log", false);
        logger.addAppender(appender);

        logger.setLevel((Level) Level.DEBUG);

    }
    catch(IOException e) {
        e.printStackTrace();
        logger.error("Printing ERROR Statements",e);
    }
}