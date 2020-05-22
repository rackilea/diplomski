package runners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Runner2 implements Runnable{
    private static final Logger log = LogManager.getLogger();

    public void run() {
        //Set up the context before getting logger
        ThreadContext.put("logFolder", "Folder2");
        ThreadContext.put("logFileName", "log2");

        //Generate some logs
        log.info("here's the second thread");
        log.debug("some debug in second thread");

    }
}