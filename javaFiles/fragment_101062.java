public static void ClickLink(By locator) throws IOException
{
    waitForHeader();
    find(locator).isDisplayed();
    CaptureScreenshot.Screenshot(driver, "Application HomePage-");
}