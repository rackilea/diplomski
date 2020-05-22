WebElement select = driver.findElement(By.name("myselect"));
Select dropDown = new Select(select);           
String selected = dropDown.getFirstSelectedOption().getText();
if(selected.equals(valueToSelect)){
    //already selected; 
    //do stuff
}
List<WebElement> Options = dropDown.getOptions();
for(WebElement option:Options){
    if(option.getText().equals(valueToSelect)) {
      option.click(); //select option here;       
    }               
}