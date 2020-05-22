public class travelComps {
    static ChromeDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "Chromedriver76PAth");

        ChromeOptions cop = new ChromeOptions();

        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        loggingprefs.enable(LogType.CLIENT, Level.ALL);
        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);
        loggingprefs.enable(LogType.PROFILER, Level.ALL);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        cop.setCapability("goog:loggingPrefs", loggingprefs);

        cop.merge(capabilities);
        driver = new ChromeDriver(cop);
        driver.get("http://automationpractice.com/index.php");

        logBrowserConsoleLogs();

        driver.quit();

    }

    private static void logBrowserConsoleLogs() {

        all(LogType.PERFORMANCE);

    }

    public static void all(String logTypes) {
        System.out.println("================== " + logTypes + "  LOGS =======================");

        List<LogEntry> logEntries = driver.manage().logs().get(logTypes).getAll();
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        System.out.println("=======================================================");
    }