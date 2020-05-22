WebElement label = driver.findElement(By.xpath("xpath"));

WebElement parentOfLabel = label.findElement(By.xpath("parent::*"));

WebElement myObject = parentOfLabel.findElement(By.xpath("*//input[@id='abc']"));

myObject.sendKeys("found");