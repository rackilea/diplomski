import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class FileHandlerTest {

    private static final Logger logger = Logger.getLogger("tester");

    static {
        try {
            FileHandler h = new FileHandler();
            logger.addHandler(h);
            h.setFormatter(new TestFormatter());
        } catch (IOException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static class TestFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return record.getSourceClassName();
        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println(new File(".").getCanonicalPath());
        System.out.println(System.getProperty("user.home"));
        logger.log(Level.INFO, "This not a test. This is the real thing!");
    }
}