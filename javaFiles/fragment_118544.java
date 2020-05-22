package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnotherClass {
    private static final Logger log = LogManager.getLogger();   

    public void logSomething(){
        log.info("This is yet another info message");
    }
}