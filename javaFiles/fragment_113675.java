Map<String, Appender> appenders = config.getAppenders();
for (Appender appender : appenders.values()) {
    if (appender instanceof RollingFileAppender) {
        ((RollingFileAppender) appender).getManager().setRolloverStrategy(newStrategy);
    }
}