public static WebDriver startDriver(Browsers browserType)
{
    switch (browserType)
    {
        case FIREFOX:
            ...
            return new FirefoxDriver();
        case CHROME:
            ...
            return new ChromeDriver();
        case IE32:
            ...
            return new InternetExplorerDriver();
        case IE64:
            ...
            return new InternetExplorerDriver();
        default:
            throw new InvalidParameterException("Unknown browser type");
    }
}
public enum Browsers
{
    CHROME, FIREFOX, IE32, IE64;
}