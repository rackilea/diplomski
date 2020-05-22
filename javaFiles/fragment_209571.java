public void clickOnElement(WebElement element, boolean waitForStaleness) {
    element.click();
    if (waitForStaleness) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }
}

public void clickOnElement(WebElement element) {
    clickOnElement(element, false);
}