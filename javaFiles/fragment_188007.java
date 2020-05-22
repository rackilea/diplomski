// Checks if a WebElement is present on the screen
public void isElementPresent(WebElement element) {
    try {
        element.isDisplayed();
    } catch (RuntimeException e) {
        throw e;
    }
}