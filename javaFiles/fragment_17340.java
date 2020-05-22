DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

ChromeOptions options = new ChromeOptions();
options.setBinary("D:\\m_ali\\GoogleChromePortable\\GoogleChromePortable.exe");
capabilities.setCapability(ChromeOptions.CAPABILITY, options);

System.setProperty("webdriver.chrome.driver", "D:\\m_ali\\chromeDriver\\chromedriver_2.27win32\\chromedriver.exe");

driver = new ChromeDriver(capabilities);