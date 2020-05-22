import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

public class TestA {
    protected static Logger LOGGER = Logger.getLogger(TestA.class);

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.warn("beforeSuite - TestA");
    }
}