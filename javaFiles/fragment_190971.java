List<WebElement> element=driver.findElements(By.cssSelector(".input-horizon.horizon-program-guide.form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty.ng-valid-min"));    
 System.out.Println(element.size());   
 if(element.isDisplayed()==true){
 System.out.Println("element is present");
 }
 else
 {
 System.out.Println("element is not present");
 }