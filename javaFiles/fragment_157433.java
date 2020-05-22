final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
final Configuration config = ctx.getConfiguration();

Layout layout = PatternLayout.createLayout(PatternLayout.SIMPLE_CONVERSION_PATTERN, config, null, null,null, null);
Appender appender = FileAppender.createAppender("target/test.log", "false", "false", "File", "true", "false", "false", "4000", layout, null, "false", null, config);
appender.start();
config.addAppender(appender);

AppenderRef ref = AppenderRef.createAppenderRef("File", null, null);
AppenderRef[] refs = new AppenderRef[] {ref};
LoggerConfig loggerConfig = LoggerConfig.createLogger("false", "info", "org.apache.logging.log4j", "true", refs, null, config, null );
loggerConfig.addAppender(appender, null, null);
config.addLogger("org.apache.logging.log4j", loggerConfig);
ctx.updateLoggers();