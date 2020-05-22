public void scrollToElement(WebElement element){
    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOf(element));
}