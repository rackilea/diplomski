driver.findElement(By.id("datepicker1")).click();
int currentSelectedDate = Integer.parseInt(driver.findElement(By.cssSelector(".ui-state-highlight")).getText());
driver.findElement(By.cssSelector(".ui-state-highlight")).click();
driver.findElement(By.id("datepicker2")).click();
if(currentSelectedDate>=30)
    driver.findElement(By.xpath("//a[@class='ui-state-default'][contains(text(),'1')]")).click();
else
    driver.findElement(By.xpath("//a[@class='ui-state-default'][contains(text(),'"+(currentSelectedDate+1)+"')]")).click();