//Setting implicit wait to 0 to avoid mess with explicit waits
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//Use WebDriverWait instead of FluentWait (it's superclass)
Wait<WebDriver> wait = new WebDriverWait(driver, 25, 500);
for(int i = 1; i <= fieldCount; i++) {
    String elementId = "field$" + i;
    String javaScript = String.format("document.getElementById('%s').value='%s';", elementId , myValue);
    Object jsResult = wait.until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
    javaScript = String.format("return document.getElementById('%s').dispatchEvent(new Event('change'));", elementId);
    jsResult = wait.until(ExpectedConditions.jsReturnsValue(javaScript));
}