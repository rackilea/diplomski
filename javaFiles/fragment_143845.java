ChromeOptions options = new ChromeOptions()
options.setBinary(new File("/path/to/chrome"));

DesiredCapabilities capabilities = DesiredCapabilities.chrome();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);

ChromeDriver driver = new ChromeDriver(capabilities);