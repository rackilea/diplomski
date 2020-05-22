wb=driver.findElement(By.xpath(".//*[@id='GB_window']/div[2]/iframe[@id='GB_frame1']"));
driver.switchTo().frame(wb);
//This is taking me to outer frame
wb=driver.findElement(By.xpath("//iframe[@id='GB_frame']"));
driver.switchTo().frame(wb);
//This is taking me to inner frame which is inside the outer frame
System.out.println("Frame Name ="+driver.getTitle());
wb=driver.findElement(By.xpath(".//*[@id='j_username']"));
wb.click();
wb.sendKeys("sdfs");