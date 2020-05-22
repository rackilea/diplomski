Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

    String browserName = cap.getBrowserName();
    String browserVersion = (String)cap.getCapability("browserVersion");
    String osName = Platform.fromString((String)cap.getCapability("platformName")).name().toLowerCase();

    return browserName + browserVersion + "-" + osName;