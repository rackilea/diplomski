package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LogFileNameBasedOnArg0Main {

    public static void main(String[] args) {
        ThreadContext.put("fileName", args[0]);
        Logger log = LogManager.getLogger();
        log.info("Here's some info!");
    }

}