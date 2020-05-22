public bool isStarsSelectedOnMouseOver(int n){
    Actions action = new Actions(driver);
    action.moveToElement(driver.findElement(by.xpath("//li[@class='rw-ui-star-"+(n-1)+"'"))).build().perform();

    List<WebElement> stars = driver.findElements(by.xpath("//ul[@class='rw-ui-stars'"));

    for(int i = 1; i <= n; i++){
        if(!stars.get(i).getAttribute("class").contains("rw-ui-star-over"))
            return false;
    }
    return true;
}