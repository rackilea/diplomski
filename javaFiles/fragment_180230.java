package runners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Runner1 implements Runnable{
    private static final Logger log = LogManager.getLogger();

    public void run() {
        //Set up the context before getting logger
        ThreadContext.put("logFolder", "Folder1");
        ThreadContext.put("logFileName", "log1");

        //Generate some logs
        log.info("here's the first thread");

        //Wait a while so that threads interleave
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Generate more logs
        log.debug("some debug in first thread");
        log.info("finishing first thread");

    }
}