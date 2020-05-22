public static AppiumDriver<MobileElement> driver;
public static AppiumDriver<MobileElement> setupDesiredCapabilities(String appPackage, String appActivity,
                                                                       String udid, String platformVersion, boolean noReset) {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Android phone");  //any name
        caps.setCapability("udid", udid);   
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("noReset", noReset);    //optional


        try {
            driver = new AndroidDriver<MobileElement>(new URL(
                    "http://127.0.0.1:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            //
        } catch (Exception ex) {
            //
        }

        return driver;
    }