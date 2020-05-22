import java.util.logging.Logger;

public class TestLogging {

    static final Logger log = Logger.getLogger(TestLogging.class.getName());

    public static void main(String[] args) {
        log.info("Test");
    }

}