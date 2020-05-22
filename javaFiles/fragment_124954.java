import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Test {
  public static void main(String[] args) throws Exception {
    System.setProperty("java.util.logging.config.file", "config1.properties");
    Logger logger = Logger.getLogger(Test.class.getSimpleName());
    logger.info("Message 1");
    System.setProperty("java.util.logging.config.file", "config2.properties");
    LogManager logManager = LogManager.getLogManager();
    logManager.readConfiguration();
    logger = Logger.getLogger(Test.class.getSimpleName());
    logger.info("Message 2");
  }
}