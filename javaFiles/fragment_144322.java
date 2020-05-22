System.setProperty("webdriver.chrome.driver", "D:\\Application\\chromedriver.exe");
driver = new ChromeDriver(); 
driver.manage().window().maximize();
driver.get("http://mmcd.nmrfam.wisc.edu/");
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.switchTo().frame("leftFrame");
driver.findElement(By.cssSelector("td > img[name='navbut4']")).click();