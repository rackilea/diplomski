public static WebElement findElement(WebDriver driver, By selector, long timeOutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
    wait.until(ExpectedConditions.presenceOfElementLocated(selector));

    return findElement(driver, selector);
}