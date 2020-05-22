WebElement email = driver.findElement(By.id("email"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement submit = driver.findElement(By.id("submit"));
    email.sendKeys("John");
    email.password("foo");
    submit.submit();