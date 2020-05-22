WebElement select = driver.findElement(By.tagName("select"));
List<WebElement> allOptions = select.findElements(By.tagName("option"));
for (WebElement option : allOptions) {
    if("yourDesiredValue".equals(option.getAttribute("value"))){
        option.click();
    }
}