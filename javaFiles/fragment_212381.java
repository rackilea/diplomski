@RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/resources/features"},
            glue = {"com.cucumber.stepdefinitions"},
            plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
            )
    public class RunCukesTest {
        @AfterClass
        public static void teardown() {
            Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("os", "Mac OSX");
            Reporter.setTestRunnerOutput("Sample test runner output message");
        }
    }