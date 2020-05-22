class WebDriverFactory {
static {
    System.setProperty("webdriver.ie.driver", "src/test/resources/webDrivers/IEDriverServer.exe");
}

static WebDriver internetExplorerWebDriver() {
    DesiredCapabilities returnCapabilities = DesiredCapabilities.internetExplorer();
        System.setProperty("webdriver.ie.driver", "src/test/resources/webDrivers/IEDriverServer.exe");
    returnCapabilities.setCapability("requireWindowFocus", true);
    returnCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
    returnCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
    returnCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    returnCapabilities.setCapability("ignoreZoomSetting", true);

    try {
        return new RemoteWebDriver(new URL("http://www.google.com"), returnCapabilities);
    } catch (MalformedURLException e) {
        return null;
    }

}