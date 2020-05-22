import org.apache.log4j.Logger;
...
public class SomeClass {
    private Logger logger = Logger.getLogger("GENERAL_LOGGER");
...
    logger.info("some info");
}