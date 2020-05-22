LoggingPreferences loggingPreferences = new LoggingPreferences();
loggingPreferences.enable(LogType.BROWSER, Level.ALL);
loggingPreferences.enable(LogType.CLIENT, Level.ALL);
loggingPreferences.enable(LogType.DRIVER, Level.ALL);
loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
loggingPreferences.enable(LogType.PROFILER, Level.ALL);
loggingPreferences.enable(LogType.SERVER, Level.ALL);
DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

WebDriver driver = new FirefoxDriver(desiredCapabilities);
driver.get("http://www.google.com");
Logs logs = driver.manage().logs();
LogEntries logEntries = logs.get(LogType.DRIVER); //now pick the LOG type you want
for (LogEntry logEntry : logEntries) {
    System.out.println(logEntry.getMessage());
    //or save write it to log4j etc.
}