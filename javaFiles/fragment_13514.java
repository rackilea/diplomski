private boolean elementNotOnPage(){
    boolean elementIsNotOnPage = false;

    List<WebElement> element = driver.findElements(yourLocator);

    if(element.size() == 0){
        elementIsNotOnPage = true;
    }

    return elementIsNotOnPage;

}