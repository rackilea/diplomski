public static void main(String[] args) {
    // Execute some jobs
    for (int n = 0; n < 10; n++) {
        dummyJob(n);
    }
}

private static void dummyJob(int n) {
    final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
    final AbstractConfiguration config = (AbstractConfiguration) ctx.getConfiguration();

    // Create and add the appender
    CustomAppender appender = new CustomAppender("Custom", null, PatternLayout.createDefaultLayout());
    appender.start();
    config.addAppender(appender);

    // Create and add the logger
    AppenderRef[] refs = new AppenderRef[]{AppenderRef.createAppenderRef("Custom", null, null)};
    LoggerConfig loggerConfig = LoggerConfig.createLogger("false", Level.INFO, "com.company", "true", refs, null, config, null);
    loggerConfig.addAppender(appender, null, null);
    config.addLogger("com.company", loggerConfig);
    ctx.updateLoggers();

    // Run the job
    Logger logger = LogManager.getLogger("com.company");
    logger.info("Job {}", n);
    logger.info("Hello, World!");
    logger.info("This is awesome!");
    logger.info("Hope it works!");
    logger.info("Hope it helps!");

    // Remove the logger and appender
    config.removeLogger("com.company");
    config.removeAppender("Custom");
    ctx.updateLoggers();

}