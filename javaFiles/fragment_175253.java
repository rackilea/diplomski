public void SetUp(String browser) {

     if(browser.equalsIgnoreCase("firefox")) {

          driver = new FirefoxDriver();

      // If browser is Chrome, then do this   

      }else { 

          System.setProperty("webdriver.chrome.driver","C:/Users/elsid/Desktop/Eclipse/Selenium/chromedriver.exe");
          driver = new ChromeDriver();

          { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
          {driver.manage().window().maximize();}
           driver.get(Constant.URL);
      }
}