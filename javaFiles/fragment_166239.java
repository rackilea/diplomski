@BeforeClass 
    baseUrl = "http://localhost:8080/";
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(baseUrl);

and @AfterClass
  driver.quit();