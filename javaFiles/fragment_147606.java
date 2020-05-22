import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleLoggerTest {
    private static ByteArrayOutputStream outContent;
    private static Logger logger = null;
    private static PrintStream printStream;

    @BeforeClass
    public static void init() {
        SampleLoggerTest.outContent = new ByteArrayOutputStream();
        SampleLoggerTest.printStream = new PrintStream(SampleLoggerTest.outContent);
        System.setOut(SampleLoggerTest.printStream);
        SampleLoggerTest.logger = LogManager.getLogger(SampleLoggerTest.class);
    }

    @Test
    public void debug() {
        SampleLoggerTest.logger.debug("OnLogger");
        Assert.assertTrue(SampleLoggerTest.outContent.toString().contains("DEBUG"));
    }

    @Test
    public void error() {
        SampleLoggerTest.logger.error("OnLogger");
        Assert.assertTrue(SampleLoggerTest.outContent.toString().contains("ERROR"));
    }

    @Test
    public void fatal() {
        SampleLoggerTest.logger.fatal("OnLogger");
        Assert.assertTrue(SampleLoggerTest.outContent.toString().contains("FATAL"));
    }

    @Test
    public void info() {
        SampleLoggerTest.logger.info("OnLogger");
        Assert.assertTrue(SampleLoggerTest.outContent.toString().contains("INFO"));
    }

    @Test
    public void trace() {
        SampleLoggerTest.logger.trace("OnLogger");
        Assert.assertTrue(SampleLoggerTest.outContent.toString().contains("TRACE"));
    }

    @Test
    public void warn() {
        SampleLoggerTest.logger.warn("OnLogger");
        Assert.assertTrue(SampleLoggerTest.outContent.toString().contains("WARN"));
    }
}