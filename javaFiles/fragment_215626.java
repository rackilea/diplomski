public class Utils {
public static void rollover(LoggerContext loggerContext) {
    Map<String, Appender> appendersByName = loggerContext.getConfiguration().getAppenders();

    appendersByName.values().forEach(appender -> {
        if (appender instanceof RollingFileAppender) {
            ((RollingFileAppender) appender).getManager().checkRollover(new RolloverLogEvent());
        }
    });
}
}

@Plugin(name = "OnTriggeringPolicy", category = "Core", printObject = true)
public class OnCustomTriggeringPolicy implements TriggeringPolicy {

private RollingFileManager manager;

@PluginFactory
public static OnRolloverEventEventTriggeringPolicy createPolicy() {
    return new OnRolloverPolicy();
}

@Override
public void initialize(RollingFileManager manager) {
    this.manager = manager;
}

@Override
public boolean isTriggeringEvent(LogEvent logEvent) {

    return manager.getFileSize() > 0;
}
}