final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
// You should know only appender name.
RollingFileAppender appender = (RollingFileAppender) ctx.getConfiguration().getAppenders().get(appenderName);
if (appender != null) {
  // Manually start rollover logic.
  appender.getManager().rollover();
}