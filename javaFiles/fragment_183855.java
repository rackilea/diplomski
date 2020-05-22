driver.findElement(By.id("search_key.combobox")).click();//click on that combo
for(int i = 0; i <= position; i++){
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.ENTER).build().perform();//press enter
}

//here "position" is , ur desired combo box option position,
//for ex. u want to choose 3rd option,so ur "position" will be 3.