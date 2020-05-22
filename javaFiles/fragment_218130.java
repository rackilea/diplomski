driver.get("http://google.com");
driver.manage().window().maximize();
WebElement name = driver.findElement(By.id("lst-ib"));
name.sendKeys("Neethu Raghavan");
driver.findElement(By.id("_fZl")).click();
Thread.sleep(2500);          // wait for 2.5 seconds