Webdriver driver = new ChromeDriver();
   driver.get("URL of application");
   driver.findElement(By.id("username").sendKeys("user1");
   driver.findElement(By.id("password").sendKeys("pass1");
   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
   driver.findElement(By.xPath("xpath of button").click();