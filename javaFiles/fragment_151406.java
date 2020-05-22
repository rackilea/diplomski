public WebDriver GetBrowser() {
     System.setProperty("webdriver.chrome.driver",  "E:\\chromedriver.exe");
     driver = new ChromeDriver();
     String baseurl = "https:\\live.guru99.com\\index.php\\";
     driver.get(baseurl);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     return driver;
}