public class Log4jTest {
    private static final Logger logger = LogManager.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warning");
        logger.error("Error");
        logger.fatal("Fatal");
    }
}