WebElement element = driver.findElement(By.xpath("someXpath"));
int halfOfHeight = element.getSize().getHeight()/2;
// moveToElement* method moves to the middle of element, so we'll also move on half of element and click on the 3rd pix from the bottom
int offset = halfOfHeight - 3; 

Actions actions = new Actions(driver);
actions
       .moveToElement(element)
       .moveByOffset(0, offset)
       .click()
       .build()
       .perform();