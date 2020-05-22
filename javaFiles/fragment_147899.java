final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
final ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--start-maximized");
Map<String, Object> prefs = new LinkedHashMap<>();
prefs.put("credentials_enable_service", Boolean.valueOf(false));
prefs.put("profile.password_manager_enabled", Boolean.valueOf(false));
chromeOptions.setExperimentalOption("prefs", prefs);
capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
WebDriver driver = new ChromeDriver(capabilities);