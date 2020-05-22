DesiredCapabilities d = DesiredCapabilities.chrome();
LoggingPreferences logPrefs = new LoggingPreferences();
logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
d.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
WebDriver driver = new ChromeDriver(d);
driver.get("https://www.google.co.in/");
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
LogEntries les = driver.manage().logs().get(LogType.PERFORMANCE);
for (LogEntry le : les) {
    System.out.println(le.getMessage());
}