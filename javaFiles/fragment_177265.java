package org.stackoverflow;

import org.apache.log4j.Logger;

/**
 * @author maba, 2012-08-22
 */
public class Log4JTest {

    public static final Logger log = Logger.getLogger(Log4JTest.class);

    public static void main(String[] args) {
        log.error("Error in main");
    }
}