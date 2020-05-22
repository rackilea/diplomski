WebDriver driver = new FirefoxDriver();
        driver.get("http://stackoverflow.com/");
        WebElement e = driver.findElement(By.xpath(".//*[@id='nav-questions']"));       
        Actions action = new Actions(driver); 
        action.keyDown(Keys.CONTROL).build().perform(); //press control key
        e.click();
        Thread.sleep(10000); // wait till your page loads in new tab
        action.keyUp(Keys.CONTROL).build().perform(); //release control key
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t"); //move to new tab
        driver.navigate().refresh(); // refresh page
        driver.findElement(By.xpath(".//*[@id='hlogo']/a")).click(); //perform any action in new tab. I am just clicking logo
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t"); //switch to first tab
        driver.navigate().refresh(); 
        driver.findElement(By.xpath(".//*[@id='hlogo']/a")).click();// refresh first tab & continue with your further work.I am just clicking logo