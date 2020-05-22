@BeforeClass
public void setUp() throws MalformedURLException{
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName","Android");
    desiredCapabilities.setCapability("deviceName", "Any name");
    desiredCapabilities.setCapability("udid", "9NLJA17619012618");
    desiredCapabilities.setCapability("appActivity", ".activity.LaunchActivity");
    desiredCapabilities.setCapability("appPackage", "com.aaa.app");     
    desiredCapabilities.setCapability("platformVersion", "7.1.2");
    URL url = new URL("http://localhost:4723/wd/hub");
    driver = new AndroidDriver<MobileElement>(url,desiredCapabilities);
}