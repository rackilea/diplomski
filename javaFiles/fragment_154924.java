public class MainClass {
    private static final String ADDRESS_TO_TEST = "https://www.gmail.com";

    private static final By EMAIL_INPUT = By.id("Email");
    private static final By PASSWORD_INPUT = By.id("Passwd");
    private static final By SIGN_IN_BUTTON = By.id("signIn");

    private static final String EMAIL = "test@abc.com";
    private static final String PASSWORD = "test123";

    private WebDriver driver;

    public MainClass() {
        File file = new File(BROWSER_PATH);
        FirefoxBinary fb = new FirefoxBinary(file);
        driver = new FirefoxDriver(fb, new FirefoxProfile());
        driver.get(ADDRESS_TO_TEST);
    }

    public static void main(String[] args) throws IOException, BiffException {
        MainClass main = new MainClass();

        //main.handleTestSuite();

        main.operateWebDriver("Click", EMAIL_INPUT);
        main.operateWebDriver("SendKey", EMAIL_INPUT, EMAIL);
        main.operateWebDriver("Click", PASSWORD_INPUT);
        main.operateWebDriver("SendKey", PASSWORD_INPUT, PASSWORD);
        main.operateWebDriver("Click", SIGN_IN_BUTTON);
    }

    private void operateWebDriver(String operation, By element) {
        operateWebDriver(operation, element, null);
    }

    private void operateWebDriver(String operation, By element, String keys) {
        WebElement we = driver.findElement(element);

        if (operation.equalsIgnoreCase("SendKey")) {
            we.sendKeys(keys);
        } else if (operation.equalsIgnoreCase("Click")) {
            we.click();
        }
    }
}