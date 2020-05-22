public class PageObject
{
    private WebDriver driver;
    private By waitForLocator = By.id("someId"); // this is a locator for some element on the page that is last to load

    private By errorLocator = By.cssSelector("div.errorPage");
    private By warningLocator = By.cssSelector("span.message.message-error");
    private By buttonLocator = By.cssSelector("button");

    public PageObject(WebDriver webDriver)
    {
        this.driver = webDriver;

        // wait for page to finish loading
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(waitForLocator));

        if (errorExists())
        {
            throw new IllegalStateException("There are errors on the page.");
        }
        if (warningExists())
        {
            throw new IllegalStateException("There are warnings on the page.");
        }
    }

    public void clickButton()
    {
        driver.findElement(buttonLocator).click();
    }

    public boolean errorExists()
    {
        return !driver.findElements(errorLocator).isEmpty();
    }

    public boolean warningExists()
    {
        return !driver.findElements(warningLocator).isEmpty();
    }
}