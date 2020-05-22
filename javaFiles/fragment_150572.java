public class LogbackConfigurator {
    private static final Logger LOG =
            LoggerFactory.getLogger(LogbackConfigurator.class);

    public static boolean configure(String resource) throws JoranException {
        final InputStream configInputStream = LogbackConfigurator.class.getResourceAsStream(resource);
        final LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(loggerContext);
        //  the context was probably already configured by default configuration rules
        loggerContext.reset();

        if(configInputStream != null) {
            try {
                configurator.doConfigure(configInputStream);
            } catch (JoranException e) {
                e.printStackTrace();
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
            return true;
        } else {
            LOG.error("Unable to find logback file: {}", resource);
            StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
            return false;
        }
    }
}