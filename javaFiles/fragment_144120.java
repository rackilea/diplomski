for (int index=0; index<links.size(); index++ ) {
      links = driver.findElements(By.tagName("a")); 
      links.get(index).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.getTitle();
      driver.navigate().back(); 
   }