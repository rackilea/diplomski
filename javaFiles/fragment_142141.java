List<WebElement> element = driver.findElements(By.tagName("age-question-button"));

    for(int i = 0 ; i< element.size() ; i++){
        boolean isChecked =  element.get(i).findElement(By.cssSelector("input[type='checkbox']")).isSelected();
        if(isChecked){
              System.out.println("is checked and it will click on checkbox if it is checked");

               element.get(i).click();
        }  
    }