public WebDriver getDriver(String locale){   
    System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--lang=" + locale);
    return new ChromeDriver(options);
}

public void initializeSelenium() throws Exception{
    driver = getDriver("es"); // two letters to represent the locale, or two letters + country
}