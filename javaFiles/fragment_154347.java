By selector  = By.cssSelector("#dataTableAdvertisers a");
List<WebElement> elements = driver.findElements(selector);

//This just controls the loop. Iterating through the collection will return StaleElement ref exception
for (int i = 0; i<elements.size(); i++){

    //Just want to delete the first item on the list
    By xpath = By.xpath("//table[@id='dataTableAdvertisers']//a[not(.='RealMedia')]");

    if (driver.findElements(xpath).size()>0){
        WebElement element = driver.findElements(xpath).get(0);

        element.click();

        //click the delete button
        driver.findElement(By.xpath(".//*[@id='deleteAdv']")).click();
    }
}