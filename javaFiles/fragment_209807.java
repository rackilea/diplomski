driver.findElement(By.id("fj")).click();

WebDriverWait wait = new WebDriverWait(driver, 15);
wait.until(ExpectedConditions.titleContains("Selenium"));

System.out.println(driver.getTitle());