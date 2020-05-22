List<WebElement> elements = Driver.findElements(By.xpath(
    "//div[contains(@class,'ng-binding')]"));

if (elements.size() > 1) {
    return elements.get(1);
} else {
    // Do something different
}