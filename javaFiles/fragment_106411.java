WebDriverWait wait = new WebDriverWait(driver, 10);

WebElement sideMenuButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.menu-toggler.sidebar-toggler")));

Actions actions = new Actions(driver); 
actions.moveToElement(sideMenuButton).click().perform();