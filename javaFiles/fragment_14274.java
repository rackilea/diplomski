public class GoogleSearchTest
{
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.doSearch("selenium");
        System.out.println(driver.getCurrentUrl().contains("#q=selenium"));
    }
}