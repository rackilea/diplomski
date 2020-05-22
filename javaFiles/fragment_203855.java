public class Main {

    static WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) {
        hotOrNotLogin("emailAddress", "password");
    }

    public static void hotOrNotLogin(String emailAddress, String password) {

        final String OR_SPINNTER_CLASSNAME = "dropdown-link";
        final String SIGNUP_BY_EMAIL_CLASSNAME = "a.js-ovl-open.b-link";
        final String EMAIL_INPUT_NAME = "email";
        final String PASSWORD_INPUT_NAME = "password";
        WebDriverWait wait = new WebDriverWait(driver, 8);

        driver.get("http://hotornot.com/");

        //move cursor to the Or spinner to reveal the drop-down
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(OR_SPINNTER_CLASSNAME)));
        WebElement orSpinner = driver.findElement(By.className(OR_SPINNTER_CLASSNAME));
        Actions actions = new Actions(driver);
        actions.moveToElement(orSpinner);
        actions.perform();

        //sign in with email
        driver.findElement(By.cssSelector(SIGNUP_BY_EMAIL_CLASSNAME)).click();
        driver.findElement(By.name(EMAIL_INPUT_NAME)).sendKeys(emailAddress);
        driver.findElement(By.name(PASSWORD_INPUT_NAME)).sendKeys(password + Keys.RETURN);

    }
}