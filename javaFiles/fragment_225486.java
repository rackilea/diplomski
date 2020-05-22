protected WebElement waitForPresent(final String locator, long timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    WebElement ele = null;
    try {
        ele = wait.until(ExpectedConditions
                .presenceOfElementLocated(locator));
    } catch (Exception e) {
            throw e;
    }
    return ele;
}

protected WebElement waitForNotPresent(final String locator, long timeout) {
    timeout = timeout * 1000;
    long startTime = System.currentTimeMillis();
    WebElement ele = null;
    while ((System.currentTimeMillis() - startTime) < timeout) {
        try {
            ele = findElement(locator);
            Thread.sleep(1000);
        } catch (Exception e) {
            break;
        }
    }
    return ele;
}