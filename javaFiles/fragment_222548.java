public class HomePage
{
    private WebDriver driver;
    public WebElement staleElement;
    private By waitForLocator = By.id("sampleId");

    // please put the variable declarations in alphabetical order
    private By sampleElementLocator = By.id("sampleId");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        // wait for page to finish loading
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(waitForLocator));

        // see if we're on the right page
        if (!driver.getCurrentUrl().contains("samplePage.jsp"))
        {
            throw new IllegalStateException("This is not the XXXX Sample page. Current URL: " + driver.getCurrentUrl());
        }
    }

    public void clickSampleElement()
    {
        // sample method code goes here
        driver.findElement(sampleElementLocator).click();
    }
}