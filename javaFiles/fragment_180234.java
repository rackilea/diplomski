public void waitForElementToBeVisible(String cssSelector) throws Throwable {
    try {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))
        ));
    } catch (Exception e) {
        System.out.println("Timeout exceeded");
        closeDriver();
    }
}