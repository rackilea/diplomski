JavascriptExecutor js = (JavascriptExecutor) driver;
WebDriverWait wait = new WebDriverWait(driver, 5);

List<WebElement> elements = driver.findElements(By.className("needToClick"));
elements.forEach(e -> {
    js.executeScript("arguments[0].click();", e);
    wait.until(ExpectedConditions.attributeToBe(e,"class", "dontNeedToClick"));
    //if element have not only dontNeedToClick class use attributeContains
    //wait.until(ExpectedConditions.attributeContains(e,"class", "dontNeedToClick"));
});