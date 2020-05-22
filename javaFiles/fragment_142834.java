package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeClass2 {

    private static final Logger LOG = LogManager.getLogger();
    private static final Logger SPECIAL_LOG = LogManager.getLogger("SPECIAL_LOGGER");   

    public static void main(String[] args){

        if(LOG.isDebugEnabled())
            LOG.debug("This is some debug!");
        LOG.info("Here's some info!");
        //To log a special kind of message use the special logger
        SPECIAL_LOG.info("Something special goes here");
        LOG.error("Some error happened!");
    }
}