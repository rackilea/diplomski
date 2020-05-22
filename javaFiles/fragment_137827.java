//see if we can find the offending logger through slf4j's LoggerFactory
org.slf4j.Logger logger = 
    LoggerFactory.getLogger(Class.forName("org.quartz.core.QuartzSchedulerThread"));
if (logger != null && logger instanceof ch.qos.logback.classic.Logger) {
    //the slf4j Logger interface doesn't expose any configuration API's, but 
    //we can cast to a class that does; so cast it and disable the logger
    ((ch.qos.logback.classic.Logger)logger).setLevel(
        ch.qos.logback.classic.Level.OFF);
}