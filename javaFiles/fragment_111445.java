public void clickElementWithJS(By locator) {
    String jsClickCode = "arguments[0].scrollIntoView(true); arguments[0].click();";
    try {
        WebElement elementToClick = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript(jsClickCode, elementToClick);
    } catch(Exception e) {
        System.out.println("Element could not be clicked.. "  + e.getMessage());
    }
}