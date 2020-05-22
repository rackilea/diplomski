package com.example.mydao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// other imports not shown...

public class TestMyDAO extends TestCase {

    private static final Logger logger = 
        LoggerFactory.getLogger(TestMyDAO.class);


    public void testA() {
        logger.debug("Logging from testA() method");
    }

    public void testB() {
        logger.debug("Logging from testB() method");
    }

    public void testThatIAmWorkingOn() {
        logger.info("Logging from my new test method at INFO level");
    }

}