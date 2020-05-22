WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
// alternative locators:
// XPath: .//iframe[@class='demo-frame']
// use src attribute
// Css Selector: iframe[src*='demos/draggable']
// XPath: .//iframe[contains(@src, 'demos/draggable')]

driver.switchTo().frame(iframe);

WebElement draggable = driver.findElement(By.id("draggable"));
// do your drag, where do you want to drop?