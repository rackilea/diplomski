package so47656300;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondClass {

  private static final Logger logger = LogManager.getLogger(SecondClass.class);

  public SecondClass() {
    logger.info("SecondClass - starting");
    logger.info("SecondClass - ending");
  }
}