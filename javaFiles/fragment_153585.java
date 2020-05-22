DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("deviceName", "xyz");
capabilities.setCapability("platformVersion", "6.0");
capabilities.setCapability("platformName", Platform.ANDROID);
capabilities.setCapability("appPackage", "com.hp.HPSupportAssistant");
capabilities.setCapability("appActivity", "com.hp.HPSupportAssistant.MainActivity");
 capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);    capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
//desiredCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);