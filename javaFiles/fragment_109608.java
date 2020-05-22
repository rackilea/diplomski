WebDriver gmail= new ChromeDriver();
gmail.get("https://www.gmail.co.in"); 
gmail.findElement(By.id("Email")).sendKeys("abcd");
gmail.findElement(By.id("next")).click();
WebDriverWait wait = new WebDriverWait(gmail, 10);
WebElement element = wait.until(
ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
gmail.findElement(By.id("Passwd")).sendKeys("xyz");