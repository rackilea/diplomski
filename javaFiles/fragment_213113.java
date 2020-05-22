public class OpenBrowser {

    public static WebDriver firefox() {
        return new FirefoxDriver();
    }

    public static WebDriver chrome() {
        return new ChromeDriver();
    }
}