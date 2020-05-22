DesiredCapabilities capabilities = DesiredCapabilities.chrome();

capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));

ChromeDriver driver = new ChromeDriver(capabilities);