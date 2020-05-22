if (arg[0].equals("log") ) {
  org.apache.logging.log4j.Logger logger
    = org.apache.logging.log4j.LogManager.getLogger("loggerNameFromXMLConfig");
  org.apache.logging.log4j.core.Logger coreLogger
    = (org.apache.logging.log4j.core.Logger)logger;
  org.apache.logging.log4j.core.LoggerContext context
    = (org.apache.logging.log4j.core.LoggerContext)coreLogger.getContext();
  org.apache.logging.log4j.core.config.BaseConfiguration configuration
    = (org.apache.logging.log4j.core.config.BaseConfiguration)context.getConfiguration();

  coreLogger.addAppender(configuration.getAppender("appenderNameFromXMLConfig"));
} else {
  //...
}