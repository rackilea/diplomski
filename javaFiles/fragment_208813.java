List<WebElement> commonElements = driver.findElements(By.id("lnkNextStep"));
      //Now only for verification purpose check the size 
      // otherwise not required

  System.out.println("Size of the common elements in the ifrmae is : "+commonElements.size());

  // now its very simple two click the second element with same attribute
  commonElements.get(1).click();  // as index of 2nd element will be 1.