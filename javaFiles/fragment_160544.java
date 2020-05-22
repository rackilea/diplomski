package so47656300;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

  private static final Logger logger = LogManager.getLogger(App.class);

  public static void main(String[] args) {
    logger.info("App.main - starting");
    new SecondClass();
    logger.info("App.main - ending");
  }
}