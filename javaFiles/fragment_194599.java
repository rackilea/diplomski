ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(By.xpath("//button[contains(.,'Btn')]"));
for(WebElement element : elements) {
    if(element.isDisplayed()) {
        element.click();
    }
}