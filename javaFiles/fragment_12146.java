public class IOSDriverManager implements Disposable{
    private IOSDriver<IOSElement> webDriver;

    private DesiredCapabilities getIOSCapsLocal() {
        DesiredCapabilities caps = new DesiredCapabilities();
        return caps;
    }

    private void createWebDriver() {
        webDriver = new IOSDriver<IOSElement>(new URL(APPIUM_SERVER_URL), getIOSCapsLocal());
    }

    public IOSDriver<IOSElement> getDriver() {
        if (webDriver == null) {
            createThreadLocalWebDriver();
        }
        return webDriver;
    }

    @Override
    public void dispose() {
        // Stop webdriver ehre
    }
}