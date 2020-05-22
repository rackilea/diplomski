public final class Driver {

    private static final String USERNAME = "name";
    private static final String ACCESS_KEY = "key";

    public static WebDriver createDriver(String browser, String version, String os) {
        // Should probably validate the arguments here
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
            capabilities.setCapability(CapabilityType.VERSION, version);
            capabilities.setCapability(CapabilityType.PLATFORM, os);
            return new RemoteWebDriver(new URL("http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"),
                                       capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failure forming the URL to create a web driver", e);
        }
    }

    private Driver() {
        throw new AssertionError("This is a static class and shouldn't be instantiated.");
    }
}