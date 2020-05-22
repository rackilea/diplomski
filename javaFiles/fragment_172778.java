// import org.apache.logging.log4j.core.LoggerContext;

LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
File file = new File("path/to/a/different/log4j2.xml");

// this will force a reconfiguration
context.setConfigLocation(file.toURI());