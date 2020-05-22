//Either add following line in the DesiredCapabilities
capabilities.setCapability(MobileCapabilityType.App, "Path to your apk file");

//OR add following two capabilities if the app is already installed in the testing device
capabilities.setCapability("appPackage", "app package name");
capabilities.setCapability("appActivity, "app activity name");