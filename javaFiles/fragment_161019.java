driver.get("https://staging.keela.co");
driver.manage().window().maximize();

new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.linkText("Log In")));
driver.findElement(By.linkText("Log In")).click();

new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-email']")));
driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("bandana@yopmail.com");
driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("keela");
driver.findElement(By.xpath("//button[@class='btn btn-sm btn-block btn-primary']")).click();