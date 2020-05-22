import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeClass {

    private static final Logger log = LogManager.getLogger();   

    public static void main(String[] args){

        log.debug("This is some debug!");
        log.info("Here's some info!");
        log.error("Some error happened!");

        Thread t = new Thread(new Runnable(){

            @Override
            public void run() {

                log.info("Here's some info!");
                log.error("Some error happened!");
            }

        }, "foo.Cohernce.1234");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            log.error(e);
        }
    }
}