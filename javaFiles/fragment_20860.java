Boolean isElementDisplayed(WebElement element){
    if (element.isDisplayed())
        return true;
    System.out.println(element + " is not displayed!");
    return false;
}

Boolean isElementEnabled(WebElement element){
    if (element.isEnabled())
        return true;
    System.out.println(element + " is not enabled!");
    return false;
}