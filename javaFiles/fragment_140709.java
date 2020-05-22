for(String value : List){
    driver.get(Link);
    Actions actions = new Actions(driver);
    WebElement input_field = driver.findElement(By.id("txtBoxSearch"));
    input_field.clear();
    actions.moveToElement(input_field);
    actions.click();            
    actions.sendKeys(value);            
    actions.build().perform();
    WebElement submit_key = driver.findElement(By.xpath("//button[contains(@title, 'Search')]"));
    actions.moveToElement(submit_key);
    actions.click();
    actions.build().perform(); 
}