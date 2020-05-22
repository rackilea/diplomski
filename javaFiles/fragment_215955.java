/**
 * Driver for web application.
 * 
 * @return driver Browser
 * @throws IOException
 */
public WebDriver getDriverBrowser() throws IOException {

if (driverBrowser == null) {
    String sBrowser = PropertyLoader.loadProperty("browser");
    driverBrowser = getBrowser(sBrowser);
    driverBrowser
            .manage()
            .timeouts()
            .implicitlyWait(
                    Integer.valueOf(PropertyLoader
                            .loadProperty("implicit_timeout_sec")),
                    TimeUnit.SECONDS);
    driverBrowser.manage().window().maximize();
}
return driverBrowser;
}