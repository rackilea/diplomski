AppiumDriver driver;
{
driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
}

public void()
{
driver.hideKeyboard();
}