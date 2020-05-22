import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestB extends TestA {

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.warn("beforeSuite - TestB");
    }

    @Test
    public void executeTest() {
        LOGGER.warn("executeTest - TestB");
    }
}