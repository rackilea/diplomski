public void enter(String word) {

    WebElement query_editbox =
            driver.findElement(By.id("query"));
    query_editbox.sendKeys(word);
    //AutoComplete is happening even after sending the Enter Key.
    // So, Value needs to be selected from the autocomplete
    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete']/div")));
    List<WebElement> matchedList=driver.findElements(By.xpath("//div[@class='autocomplete']/div"));

    System.out.println(matchedList.size());
    for(WebElement element : matchedList){
        if(element.getText().equalsIgnoreCase(word)){
            element.click();
        }
    }
    //query_editbox.sendKeys(Keys.RETURN);
}