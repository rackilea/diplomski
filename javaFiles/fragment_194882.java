// times out after 5 seconds
WebDriverWait wait = new WebDriverWait(driver, 5);

// while the following loop runs, the DOM changes - 
// page is refreshed, or element is removed and re-added
wait.until(presenceOfElementLocated(By.id("container-element")));        

// now we're good - let's click the element
driver.findElement(By.id("foo")).click();