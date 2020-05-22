driver.get("http://stackoverflow.com/");

  WebElement elementA = driver.findElement(By.cssSelector("#logo"));
  WebElement elementB = driver.findElement(By.cssSelector("#logo"));

  boolean same1 = elementA.equals(elementB);  // return true

  elementB.click();  // reloads the page, all the previous web element are now obsolete

  WebElement elementC = driver.findElement(By.cssSelector("#logo"));

  boolean same2 = elementA.Equals(elementC);  // return false