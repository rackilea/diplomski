package uk.co.farwell.stackoverflow;

import org.apache.log4j.*;

public class Log4jTest {
    static Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String args[]) {
        logger.debug("hello Log4jTest");
    }
}