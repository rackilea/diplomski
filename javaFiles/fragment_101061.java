public static void ClickLink_Accounts() throws IOException
{
    waitForHeader();
    find(Accounts).isDisplayed();
    CaptureScreenshot.Screenshot(driver, "Application HomePage-");
}

public static void ClickLink_Tasks() throws IOException
{
    waitForHeader();
    find(Tasks).isDisplayed();
    CaptureScreenshot.Screenshot(driver, "Application HomePage-");
}

public static void waitForHeader()
{
    new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(header));
}