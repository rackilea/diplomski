WebDriver driver;
List<WebElement> webElements = driver.findElements(By.xpath("test"));
if(!webElements.isEmpty()){
    if(driver.findElement(By.xpath("test")).isDisplayed()){
        // do operations
    }
 }