AppiumDriver<MobileElement> driver;
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("deviceName", "Android phone");
caps.setCapability("udid", "your device's udid");
caps.setCapability("platformName", "Android");
caps.setCapability("platformVersion", "your device's platform version");
caps.setCapability("appPackage", "your app's appPackage name");
caps.setCapability("appActivity", "your app's main appActivity name");
driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);