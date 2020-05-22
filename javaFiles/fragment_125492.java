public class MySelenium : WebDriverBackedSelenium
{
        public IWebDriver Driver { get; set; }

        public ISelenium Selenium { get; set; }


        public MySelenium(IWebDriver baseDriver, string baseUrl)
            : base(baseDriver, baseUrl)
        {
            Driver = baseDriver;
        }

        public MySelenium(IWebDriver baseDriver, Uri baseUrl)
            : base(baseDriver, baseUrl) { }

        public static void type(String locator, String testData) {
         Driver.findElement(By.name(locator)).sendKeys(testData);

    }