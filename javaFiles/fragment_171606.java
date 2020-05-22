public class DriverClass {

    private String baseUrl;
    private String driverPath;
    private String driverName;
    private static WebDriver driver;
    private static DriverClass driverClass;

    public DriverClass() {
        try {
            baseUrl = "http://192.168.0.10:8282/ess";
            driverPath = "E:\\Work_Folder\\SelTools\\chromedriver.exe";
            driverName = "webdriver.chrome.driver";
            System.setProperty(driverName, driverPath);

            Proxy proxy = new org.openqa.selenium.Proxy();
            proxy.setSslProxy("192.168.0.200" + ":" + 3128);
            proxy.setFtpProxy("192.168.0.200" + ":" + 3128);
            proxy.setSocksUsername("avishka");
            proxy.setSocksPassword("12345678");

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);


            driver = new ChromeDriver(desiredCapabilities);


            driver.get(baseUrl);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}