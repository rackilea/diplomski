// To find and click on required check-box
WebElement element = driver.findElement(By.xpath("//div[input[starts-with(@id, 'language-')]/span[text()='English']]"));
Actions actions = new Actions(driver);
actions.moveToElement(element);
actions.click();
actions.perform();