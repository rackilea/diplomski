public class FirefoxDriverCustom extends DriverCustom {

    // Add decorated object to decorator
public FirefoxDriverCustom(FirefoxDriver driver) {
    super(driver);
}

@Override
public void get(String url) {
    rwd.get(url);
}

@Override
public String getCurrentUrl() {
    return rwd.getCurrentUrl();
}

@Override
public String getTitle() {
    return rwd.getTitle();
}

@Override
public List<WebElement> findElements(By by) {
    return rwd.findElements(by);
}

@Override
public WebElement findElement(By by) {
    return rwd.findElement(by);
}

@Override
public String getPageSource() {
    return rwd.getPageSource();
}

@Override
public void close() {
    rwd.close();

}

@Override
public void quit() {
    rwd.close();

}

@Override
public Set<String> getWindowHandles() {
    return rwd.getWindowHandles();
}

@Override
public String getWindowHandle() {
    return rwd.getWindowHandle();
}

@Override
public TargetLocator switchTo() {
    return rwd.switchTo();
}

@Override
public Navigation navigate() {
    return rwd.navigate();
}

@Override
public Options manage() {
    return rwd.manage();
}

@Override
public Object executeScript(String script, Object... args) {
    return rwd.executeScript(script, args);
}

@Override
public Object executeAsyncScript(String script, Object... args) {
    return rwd.executeAsyncScript(script, args);
}

@Override
public WebElement findElementById(String using) {
    return rwd.findElementById(using);
}

@Override
public List<WebElement> findElementsById(String using) {
    return rwd.findElementsById(using);
}

@Override
public WebElement findElementByClassName(String using) {
    return rwd.findElementByClassName(using);
}

@Override
public List<WebElement> findElementsByClassName(String using) {
    return rwd.findElementsByClassName(using);
}

@Override
public WebElement findElementByLinkText(String using) {
    return rwd.findElementByLinkText(using);
}

@Override
public List<WebElement> findElementsByLinkText(String using) {
    return rwd.findElementsByLinkText(using);
}

@Override
public WebElement findElementByPartialLinkText(String using) {
    return rwd.findElementByPartialLinkText(using);
}

@Override
public List<WebElement> findElementsByPartialLinkText(String using) {
    return rwd.findElementsByPartialLinkText(using);
}

@Override
public WebElement findElementByName(String using) {
    return rwd.findElementByName(using);
}

@Override
public List<WebElement> findElementsByName(String using) {
    return findElementsByName(using);
}

@Override
public WebElement findElementByCssSelector(String using) {
    return rwd.findElementByCssSelector(using);
}

@Override
public List<WebElement> findElementsByCssSelector(String using) {
    return rwd.findElementsByCssSelector(using);
}

@Override
public WebElement findElementByTagName(String using) {
    return rwd.findElementByTagName(using);
}

@Override
public List<WebElement> findElementsByTagName(String using) {
    return rwd.findElementsByTagName(using);
}

@Override
public WebElement findElementByXPath(String using) {
    return rwd.findElementByXPath(using);
}

@Override
public List<WebElement> findElementsByXPath(String using) {
    return rwd.findElementsByXPath(using);
}

@Override
public Keyboard getKeyboard() {
    return rwd.getKeyboard();
}

@Override
public Mouse getMouse() {
    return rwd.getMouse();
}

@Override
public Capabilities getCapabilities() {
    return rwd.getCapabilities();
}

@Override
public <X> X getScreenshotAs(OutputType<X> target)
        throws WebDriverException {
    return rwd.getScreenshotAs(target);
}

// We can also add some specific firefox's methods to our decorator class.

}