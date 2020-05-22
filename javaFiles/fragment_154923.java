public class MainClass {
    private static final String BROWSER_PATH = "D:\\softs\\FF installed\\FF18\\firefox.exe";
    private static final String TEST_SUITE_PATH = "D:\\GmailTestSuite.xls";
    private static final String OBJECT_REPOSITORY_PATH = "D:\\objectrepository.xls";
    private static final String ADDRESS_TO_TEST = "https://www.gmail.com";

    private static final By EMAIL_INPUT = By.id("Email");
    // other constants

    private WebDriver driver;
    private Properties properties;

    public MainClass() {
        File file = new File(BROWSER_PATH);
        FirefoxBinary fb = new FirefoxBinary(file);
        driver = new FirefoxDriver(fb, new FirefoxProfile());
        driver.get(ADDRESS_TO_TEST);
    }

    public static void main(String[] args) throws IOException, BiffException {
        MainClass main = new MainClass();

        main.handleTestSuite();
    }

    private void handleTestSuite() {
        ReadPropertyFile readConfigFile = new ReadPropertyFile();
        properties = readConfigFile.loadPropertiess();

        ExcelHandler testSuite = new ExcelHandler(TEST_SUITE_PATH, "Suite");
        testSuite.columnData();

        int rowCount = testSuite.rowCount();
        System.out.println("Total Rows=" + rowCount);

        for (int i = 1; i < rowCount; i++) {
            String executable = testSuite.readCell(testSuite.getCell("Executable"), i);
            System.out.println("Executable=" + executable);

            if (executable.equalsIgnoreCase("y")) {
                // exe. the process
                String scenarioName = testSuite.readCell(testSuite.getCell("TestScenario"), i);
                System.out.println("Scenario Name=" + scenarioName);
                handleScenario(scenarioName);
            }
        }
    }

    private void handleScenario(String scenarioName) {
        ExcelHandler testScenarios = new ExcelHandler(TEST_SUITE_PATH, scenarioName);

        int rowWorkBook1 = testScenarios.rowCount();
        for (int j = 1; j < rowWorkBook1; j++) {
            String framWork = testScenarios.readCell(testScenarios.getCell("FrameworkName"), j);
            String operation = testScenarios.readCell(testScenarios.getCell("Operation"), j); // SendKey
            String value = testScenarios.readCell(testScenarios.getCell("Value"), j);
            System.out.println("FRMName=" + framWork + ",Operation=" + operation +
                               ",Value=" + value);

            handleObjects(operation);
        }
    }

    private void handleObjects(String operation) {
        ExcelHandler objectRepository = new ExcelHandler(OBJECT_REPOSITORY_PATH, "OR");
        objectRepository.columnData();
        int rowCount = objectRepository.rowCount();
        System.out.println("Total Rows=" + rowCount);

        for (int k = 1; k < rowCount; k++) {
            String frameWorkName = objectRepository.readCell(objectRepository.getCell("Executable"), k);
            String ObjectName = objectRepository.readCell(objectRepository.getCell("ObjectName"), k);
            String Locator = objectRepository.readCell(objectRepository.getCell("Locator"), k); // SendKey

            System.out.println("FrameWorkName=" + frameWorkName +
                               ",ObjectName=" + ObjectName + ",Locator=" + Locator);

            operateWebDriver(operation);
        }
    }

    private void operateWebDriver(String operation) {
        WebElement we = driver.findElement(EMAIL_INPUT);

        if (operation.equalsIgnoreCase("SendKey")) {
            we.sendKeys("abc@gmail.com");
            we.sendKeys("si@2013");
        } else if (operation.equalsIgnoreCase("Click")) {
            we.click();
        }
    }
}