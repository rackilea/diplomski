@Test
public void testSeleniumChromeDriver() throws IOException {
    // Create a new instance of the Chrome driver
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    Map<String, Object> deviceMetrics = new HashMap<>();
    deviceMetrics.put("width", 360);
    deviceMetrics.put("height", 640);
    deviceMetrics.put("pixelRatio", 3.0);

    Map<String, Object> mobileEmulation = new HashMap<>();
    mobileEmulation.put("deviceMetrics", deviceMetrics);
    mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
    WebDriver driver = new ChromeDriver(chromeOptions);

    // GET the page
    driver.get("http://www.fishki.net");

    try {
        assertThat(driver.getCurrentUrl(), is("http://m.fishki.net/"));
    } finally {
        //Close the browser
        driver.quit();
    }
}