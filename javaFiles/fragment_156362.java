public abstract class AbstractPage {

    private final WebDriverWait wait;

    public AbstractPage() {
        // assuming some external driver provider
        this.wait = new WebDriverWait(getDriver(), 10);
    }

    public void selectByVisibleText(final By locator, final String text) {
        new Select(waitFor(locator, ExpectedConditions::visibilityOfElementLocated)).selectByVisibleText(text);
    }

    public void selectByVisibleText(final By locator, final int number) {
        selectByVisibleText(locator, String.valueOf(number));
    }

    private WebElement waitFor(final By locator, final Function<By, ExpectedCondition<WebElement>> condition) {
        return wait.until(condition.apply(locator));
    }
}