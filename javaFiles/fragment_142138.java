WebElement elem = driver.findElement(By.className("ng-isolate-scope"));
WebElement element =  elem.findElement(By.className("ng-valid-parse"));

boolean isChecked = element.findElement(By.tagName("input")).isSelected();
if(isChecked){
    System.out.println("is checked");
    element.click();
}