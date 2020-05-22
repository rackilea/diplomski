import ch.qos.logback.classic.{Level, Logger, LoggerContext}
import org.slf4j.LoggerFactory


val loggerContext: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
val rootLogger: Logger = loggerContext.getLogger("root")

def setLevel(level: String) = {
  rootLogger.setLevel(Level.toLevel(level))
}