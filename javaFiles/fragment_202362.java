public WebElement getFirstMatchingElement(By by)
{
    List<WebElement> list = driver.findElements(by);
    if(list.size() == 0) {
        return null;
    }
    return list.get(0);
}