//Here a simple example that works for me
    package com;
    import ch.qos.logback.classic.pattern.ClassicConverter;
    import ch.qos.logback.classic.spi.ILoggingEvent;

    public class MySampleConverter extends ClassicConverter {
        long start = System.nanoTime();
        @Override
        public String convert(ILoggingEvent event) {
            long nowInNanos = System.nanoTime();
            return Long.toString(nowInNanos - start);
        }
    }
    package com;
    import java.util.HashMap;
    import java.util.Map;
    import org.slf4j.LoggerFactory;
    import ch.qos.logback.classic.Level;
    import ch.qos.logback.classic.Logger;
    import ch.qos.logback.classic.LoggerContext;
    import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
    import ch.qos.logback.classic.spi.ILoggingEvent;
    import ch.qos.logback.core.ConsoleAppender;
    import ch.qos.logback.core.CoreConstants;
    import ch.qos.logback.core.FileAppender;

    public class loggerutils {
        static Logger foo = createLoggerFor("foo", "foo.log");
        public static void main(String[] args) {
            foo.info("test");
        }

        private static Logger createLoggerFor(String string, String file) {
            String conversionWord = "nanoTime";
            String converterClass = "com.MySampleConverter";
            LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
            Map<String, String> ruleRegistry = (Map) lc
                    .getObject(CoreConstants.PATTERN_RULE_REGISTRY);
            if (ruleRegistry == null) {
                ruleRegistry = new HashMap<String, String>();
            }
            lc.putObject(CoreConstants.PATTERN_RULE_REGISTRY, ruleRegistry);
            ruleRegistry.put(conversionWord, converterClass);

            PatternLayoutEncoder ple = new PatternLayoutEncoder();
            ple.setPattern("%-20nanoTime %-30(%d{HH:mm:ss.SSS} [%thread]) - %-15(%M) - %-5level -%logger{32} - %msg%n ");

            ple.setContext(lc);
            ple.start();
            FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
            fileAppender.setFile(file);
            fileAppender.setEncoder(ple);
            fileAppender.setContext(lc);
            fileAppender.start();

            ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender<ILoggingEvent>();
            consoleAppender.setEncoder(ple);
            consoleAppender.setContext(lc);
            consoleAppender.start();

            Logger logger = (Logger) LoggerFactory.getLogger(string);
            logger.addAppender(fileAppender);
            logger.setLevel(Level.DEBUG);
            logger.setAdditive(false); /* set to true if root should log too */
            logger.addAppender(consoleAppender);
            logger.setLevel(Level.DEBUG);
            logger.setAdditive(false);
            return logger;
        }
    }