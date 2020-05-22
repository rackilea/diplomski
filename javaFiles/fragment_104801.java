public static AndroidDriver getDriver(String udid) throws MalformedURLException{

    String URL = "XXXX";
    ThreadLocal<AndroidDriver> driver = null;  

    DesiredCapabilities capabilities = new DesiredCapabilities();       
    capabilities.setCapability("device", udid);
    capabilities.setCapability("deviceName", udid);
    capabilities.setCapability("udid", udid);
    capabilities.setPlatform(Platform.ANDROID);
    capabilities.setCapability("browserName", "Chrome");    

    try {
        driver = new ThreadLocal<AndroidDriver>();
        driver.set(new AndroidDriver(new URL(URL),
                capabilities));
    } catch (MalformedURLException e) {
        System.out.println("Tackle Issue with RemoteDriverSetup");
    }
    driver.get().manage().timeouts()
            .pageLoadTimeout(20L, TimeUnit.SECONDS);
    driver.get().manage().timeouts()
            .implicitlyWait(20L, TimeUnit.SECONDS);

    return driver.get();
    }