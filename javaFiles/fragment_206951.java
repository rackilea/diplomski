By itemBoxes = By.className("item-box");
By button = By.cssSelector("[type='button'][value='Add to cart']");

List<WebElement> webElementList = driver.findElements(itemBoxes);
for (WebElement element: webElementList){
    //simply taking size if exist it will return 1
    if (element.findElements(button).size() != 1){
        //fail
    }
}