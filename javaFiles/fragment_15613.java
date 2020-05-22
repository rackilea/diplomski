driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

//Now find the dropdown 
Select select = new Select(driver.findElement(By.tagName("select"));

select.selectByVisibleText("Afghanistan");