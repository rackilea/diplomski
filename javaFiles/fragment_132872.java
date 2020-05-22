//To send attachments
//click to add
driver.findElement(By.cssSelector("span[data-icon='clip']")).click();
//add file to send by file path
driver.findElement(By.cssSelector("input[type='file']")).sendKeys("FilePath");
//click to send
driver.findElement(By.cssSelector("span[data-icon='send-light']")).click();