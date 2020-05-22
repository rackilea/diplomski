public static void Loader()
{
    By loader = By.id("spinner");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    while (true)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        }
        catch (Exception e)
        {
            break;
        }
    }
}