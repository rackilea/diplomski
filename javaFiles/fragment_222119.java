WebElement home = driver.findElement(By.xpath(//div[@id='homePage']));

Actions actions = new Actions(driver);
Action mouseOverHome = actions.moveToElement(home).build();

mouseOverHome.perform();