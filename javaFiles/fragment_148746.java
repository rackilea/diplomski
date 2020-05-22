public class BeforeTestSetup extends AppiumSetUp{


    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "chromeDriverPort", "chromeDriverPath", "deviceName"}) 
    public void setUp(String platform, String udid, String chromeDriverPort, @Optional String chromeDriverPath, String deviceName) throws Exception { 

        driver = setUp(platform, udid, chromeDriverPort, deviceName); 
    }

}