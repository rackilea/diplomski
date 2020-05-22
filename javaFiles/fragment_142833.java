package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class SomeClass {

    private static final Logger LOG = LogManager.getLogger();
    private static final Marker SPECIAL_MESSAGE = MarkerManager.getMarker("SPECIAL_MESSAGE");   

    public static void main(String[] args){

        if(LOG.isDebugEnabled())
            LOG.debug("This is some debug!");
        LOG.info("Here's some info!");
        //To log a special kind of message use the same logger but include the marker
        LOG.info(SPECIAL_MESSAGE, "Something special goes here");
        LOG.error("Some error happened!");
    }
}