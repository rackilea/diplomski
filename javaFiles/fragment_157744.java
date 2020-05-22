private final By yourElement = By.id("id");
@Override
public void isLoaded() throws Error {
    new FluentWait<WebDriver>(driver)
            .withTimeout(60, TimeUnit.SECONDS)
            .pollingEvery(1, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .until(new Function<WebDriver, Boolean>() {
                @NotNull
                @Override
                public Boolean apply(WebDriver webDriver) {
                    WebElement element = driver.findElement(yourElement);
                    return element != null && element.isDisplayed();
                }
            });
}