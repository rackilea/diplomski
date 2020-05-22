WebElement element = driver.findElement(By.tagName("age-question-button"));
boolean isChecked =  element.findElement(By.cssSelector("input[type='checkbox']")).isSelected();
if(isChecked){
    System.out.println("is checked");
    element.click();
}