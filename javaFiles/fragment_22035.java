import org.openqa.selenium.support.ui.WebDriverWait;


WebDriverWait wait = new WebDriverWait(driver, 20);

// get the main window handle
String mainHandle = driver.getWindowHandle();

// wait for a new window and switch to it
driver.switchTo().window(wait.until((WebDriver drv)->{
    for (String handle : drv.getWindowHandles()){
        if (!handle.equals(mainHandle))
            return handle;
    }
    return null;
}));

// set the context on the first frame
driver.switchTo().frame(0);