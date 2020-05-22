driver.switchTo().defaultContent(); // switch out of all frames

List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
// print out the frames.size()

driver.switchTo().frame("FWin0");
driver.switchTo().frame("Content0");
frames = driver.findElements(By.cssSelector("iframe"));
// print out the frames.size() again

// find frame element and switch to
WebElement contentFrame = driver.findElement(By.cssSelector("#content"));
// alternative css locator: By.cssSelector("iframe[id='content']")
// alternative css locator: By.cssSelector("iframe[name='content']")
// alternative css locator: By.cssSelector("iframe[src*='customSearch']")
// alternative xpath locator: By.xpath("//iframe[contains(@src, 'customSearch')]")
driver.switchTo().frame(contentFrame);