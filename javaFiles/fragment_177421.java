WebElement origin = driver.findElement(By.cssSelector("div.js-originplace a"));
Actions actions = new Actions(driver);
actions.moveToElement(origin).click().sendKeys("Delhi");
actions.build().perform();

WebElement from = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul//li[contains(., 'Delhi')]")));
from.click()