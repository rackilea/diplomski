public class Log4j2Logger {

int counter = 0;

LoggerContext ctx;

Configuration config;

Logger logger;

String loggerName = "testLogger";

String appenderName = "myAppender";

static String testMessage = "This is a Test Message";

public void log() {

    final ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
    final LoggerComponentBuilder loggerComp = builder.newLogger(loggerName, Level.ALL).addAttribute("additivity",
            false);
    builder.add(loggerComp);
    config = builder.build();
    ctx = Configurator.initialize(config);
    config = ctx.getConfiguration();
    ctx.start(config);
    ctx.updateLoggers(config);

    // To create/add the logger of the configuration specified above we can use the
    // getLogger(..) method
    logger = ctx.getLogger(loggerName);

    // Now we need to attach an appender to the logger so that our messages could be
    // logged
    logger.addAppender(addConsoleAppender(ctx.getConfiguration(), appenderName));
    while (counter < 10) {
        logger.error(testMessage + counter);
        counter++;
    }

}

private Appender addConsoleAppender(Configuration config, String appenderName) {
    Appender consoleAppender = ConsoleAppender.newBuilder().setConfiguration(config).setName(appenderName)
            .withImmediateFlush(true).build();
    consoleAppender.start();
    return consoleAppender;
    }

}