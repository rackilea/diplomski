// Draws a red border around the found element. Does not set it back anyhow.
public WebElement findElement(By by) {
    WebElement elem = driver.findElement(by);
    // draw a border around the found element
    if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
    }
    return elem;
}