driver = new ChromeDriver();    
driver.manage().window().maximize();
driver.get("https://ocloud.optitex.com/#/login/");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.findElement(By.xpath("//button/span[contains(.,'Forgot Password?')]")).click();
driver.findElement(By.xpath("//input[@name='emailField']")).sendKeys("abc@gmail.com");
driver.findElement(By.xpath("//button/span[contains(.,'Reset Password')]")).click();