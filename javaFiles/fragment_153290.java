public interface Component {

default Logger createLogger(String logFileName, String oldAppenderName, String newAppenderName, boolean append, Level level)
{
    LoggerContext context = (LoggerContext) LogManager.getContext(false);
    Configuration configuration = context.getConfiguration();

    Appender oldAppender = configuration.getAppender(oldAppenderName);

    Layout<? extends Serializable> oldLayout = oldAppender.getLayout();

    // create new appender/logger
    LoggerConfig loggerConfig = new LoggerConfig(logFileName, level, false);

    Appender appender ;
    // In my case, it is possible that the old appender could
    // either be a simple FileAppender, or a  RollingRandomAccessFileAppender,
    // so I'd like the new one to be of the same type as the old one.
    // I have yet to find a more elegant way to do create a new Appender
    // of *any* type and then copy all relevant config.
    if (oldAppender instanceof RollingRandomAccessFileAppender)
    {
        int bufferSize = ((RollingRandomAccessFileAppender)oldAppender).getBufferSize();

        RollingRandomAccessFileManager oldMananger = (RollingRandomAccessFileManager)((RollingRandomAccessFileAppender) oldAppender).getManager();

        TriggeringPolicy triggerPolicy = oldMananger.getTriggeringPolicy();
        RolloverStrategy rollStrategy = oldMananger.getRolloverStrategy();
        Filter filter = ((RollingRandomAccessFileAppender)oldAppender).getFilter();
        // Inject new log file name into filePattern so that file rolling will work properly 
        String pattern = ((RollingRandomAccessFileAppender)oldAppender).getFilePattern().replaceAll("/[^/]*-\\%d\\{yyyy-MM-dd\\}\\.\\%i\\.log\\.gz", "/"+logFileName+"-%d{yyyy-MM-dd}.%i.log.gz");
        appender = RollingRandomAccessFileAppender.newBuilder()
                                           .withFileName("logs/" + logFileName + ".log")
                                           .withFilePattern(pattern)
                                           .withAppend(append)
                                           .withName(newAppenderName)
                                           .withBufferSize(bufferSize)
                                           .withPolicy(triggerPolicy)
                                           .withStrategy(rollStrategy)
                                           .withLayout(oldLayout)
                                           .withImmediateFlush(true)
                                           .withFilter(filter)
                                           .build();
    }
    else
    {
        appender = FileAppender.newBuilder()
                               .withFileName("logs/" + logFileName + ".log")
                                .withAppend(append)
                                .withName(newAppenderName)
                                .withLayout(oldLayout)
                                .setConfiguration(configuration)
                                .withLocking(false)
                                .withImmediateFlush(true)
                                .withIgnoreExceptions(true)
                                .withBufferSize(8192)
                                .withFilter(null)
                                .withAdvertise(false)
                                .withAdvertiseUri("")
                            .build();
    }
    appender.start();
    loggerConfig.addAppender(appender, level, null);
    configuration.addLogger(logFileName, loggerConfig);
    context.updateLoggers();

    return context.getLogger(logFileName);
}