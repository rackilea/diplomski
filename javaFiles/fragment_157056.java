driver.get("http://www.google.com");
driver.findElement(By.id("lst-ib")).sendKeys("seleniumhq");
driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);

Thread.sleep(6000);

driver.get("http://www.yahoo.com");