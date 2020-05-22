public class GoogleSearchPage
{
    private WebDriver driver;
    private By waitForLocator = By.id("lst-ib"); // optional
    private By searchBoxLocator = By.id("lst-ib");
    private By searchButtonLocator = By.cssSelector("button[name='btnG']");
    private By feelingLuckyButtonLocator = By.id("gbqfbb");

    public GoogleSearchPage(WebDriver webDriver)
    {
        driver = webDriver;
        // wait for page to finish loading
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(waitForLocator));

        // see if we're on the right page
        if (!driver.getCurrentUrl().contains("https://www.google.com"))
        {
            throw new IllegalStateException("This is not the Google search page. Current URL: " + driver.getCurrentUrl());
        }
    }

    public void doSearch(String searchString)
    {
        driver.findElement(searchBoxLocator).sendKeys(searchString);
        driver.findElement(searchButtonLocator).click();
    }
}