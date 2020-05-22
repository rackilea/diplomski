WebElement elem = driver.findElement(By.className("ng-isolate-scope"));
List<WebElement> element =  elem.findElements(By.className("ng-valid-parse"));

boolean isChecked = element.get(indexOfyourdesiredELement).findElement(By.tagName("input")).isSelected();
if(isChecked){
       System.out.println("is checked");
       element.get(indexOfyourdesiredELement).click();
}