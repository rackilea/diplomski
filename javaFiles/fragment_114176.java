DesiredCapabilities capabilities = new DesiredCapabilities();
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    logPrefs.enable(LogType.DRIVER, Level.ALL);
    capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

    Map<String, Object> perfLogPrefs = new HashMap<String, Object>();
    perfLogPrefs.put("traceCategories", "browser,devtools.timeline,devtools");
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);

    WebDriver driver = new ChromeDriver(capabilities);