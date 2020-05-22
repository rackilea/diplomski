driver.get("https://www.marstranslation.com/place-order");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.findElement(By.xpath("//a/span[contains(text(), 'English')]")).click();          //Click on dropdown using xpath locator.
WebDriverWait wait = new WebDriverWait(driver, 15);    //Use explicit wait method for find an element
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul/li[contains(text(), 'Arabic')]"))));
driver.findElement(By.xpath("//ul/li[contains(text(), 'Arabic')]")).click();      //After explicit wait, click on Arabic option from dropdown using xpath locator.