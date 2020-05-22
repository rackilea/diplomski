import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassSample {
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("beforeMethod() executed", true);
    }

    @Test
    public String testMethod() {
        Reporter.log("testMethod() executed", true);
        return null;
    }
}