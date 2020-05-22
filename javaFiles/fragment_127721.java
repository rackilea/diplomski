WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

driver.get("https://login.yahoo.com/");

driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("Username");
driver.findElement(By.xpath("//*[@id='login-signin']")).click();
WebDriverWait wait = new WebDriverWait(driver,20);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-passwd']")));
driver.findElement(By.xpath("//*[@id='login-passwd']")).sendKeys("Password");