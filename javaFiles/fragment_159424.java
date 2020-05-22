public abstract class DriverCustom implements WebDriver, JavascriptExecutor,
FindsById, FindsByClassName, FindsByLinkText, FindsByName,
FindsByCssSelector, FindsByTagName, FindsByXPath,
HasInputDevices, HasCapabilities, TakesScreenshot {

    //Our decorated object
protected RemoteWebDriver rwd;

public DriverCustom(RemoteWebDriver driver) {
    rwd = driver;
}

// custom methods to add to the decorator. Must be public.

}