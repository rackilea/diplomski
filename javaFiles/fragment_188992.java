System.setProperty("webdriver.chrome.driver","<<your chrome path>>");
    // To remove message "You are using an unsupported command-line flag: --ignore-certificate-errors.
    // Stability and security will suffer."
    // Add an argument 'test-type'
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("test-type");
    capabilities.setCapability("chrome.binary","<<your chrome path>>");


capabilities.setCapability(ChromeOptions.CAPABILITY, options);

    driver = new ChromeDriver(capabilities);