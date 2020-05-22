WebElement viewsMenu = driver.findElement(By.xpath(".//*[@id='Views']/div"));
viewsMenu.click();
//or mouse over 
Actions action = new Actions(webdriver);
action.moveToElement(viewsMenu).build().perform();

//now access submenu
viewsMenu.findElement(By.xpath(".//ul[@id='subViews']/li[4]/a")).click();