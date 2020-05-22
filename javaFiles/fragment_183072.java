WebElement parent = driver.findElement(By.cssSelector(".tutor-schedule-tablet"));  
List<WebElement> children = parent.findElements(By.cssSelector("button.md-primary.md-button.ng-scope"));  


  for (int i = 0; i < children.size(); i++) { 
      if(!children.get(i).getAttribute("class").contains("timeinterval-selected"))
      {
          children.get(i).click();
      }
  }