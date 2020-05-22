private static final Logger[] PINNED_LOGGERS;
static {
    System.setProperty("org.apache.commons.logging.simplelog.defaultlog", "fatal");
    PINNED_LOGGERS = new Logger[]{
        Logger.getLogger("com.gargoylesoftware.htmlunit"),
        Logger.getLogger("org.apache.http")
    };

    for (Logger l : PINNED_LOGGERS) {
        l.setLevel(Level.OFF);
    }
}