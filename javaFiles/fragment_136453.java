PatternLayoutEncoder logEncoder = new PatternLayoutEncoder();
            logEncoder.setContext(logCtx);
            logEncoder.setPattern("%-12date{YYYY-MM-dd HH:mm:ss.SSS} %-5level - %msg%n");
            logEncoder.start();

            ConsoleAppender logConsoleAppender = new ConsoleAppender();
            logConsoleAppender.setContext(logCtx);
            logConsoleAppender.setName("console");
            logConsoleAppender.setEncoder(logEncoder);
            logConsoleAppender.start();

            logEncoder = new PatternLayoutEncoder();
            logEncoder.setContext(logCtx);
            logEncoder.setPattern("%-12date{YYYY-MM-dd HH:mm:ss.SSS} %-5level - %msg%n");
            logEncoder.start();

            RollingFileAppender logFileAppender = new RollingFileAppender();
            logFileAppender.setContext(logCtx);
            logFileAppender.setName("logFile");
            logFileAppender.setEncoder(logEncoder);
            logFileAppender.setAppend(true);
            logFileAppender.setFile("logs/logfile.log");

            TimeBasedRollingPolicy logFilePolicy = new TimeBasedRollingPolicy();
            logFilePolicy.setContext(logCtx);
            logFilePolicy.setParent(logFileAppender);
            logFilePolicy.setFileNamePattern("logs/archived/logfile-%d{yyyy-MM-dd_HH}.log.zip");
            logFilePolicy.setMaxHistory(7);
            logFilePolicy.start();

            logFileAppender.setRollingPolicy(logFilePolicy);
            logFileAppender.start();

            Logger log = logCtx.getLogger("Main");
            log.setAdditive(false);
            log.setLevel(Level.INFO);
            log.addAppender(logConsoleAppender);
            log.addAppender(logFileAppender);

            return log;