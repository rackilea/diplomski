driver.findElement(By.xpath("//span[contains(@class, 'brand-trip-search-geopill-TripSearchGeoPill__icon--jEoJX')]")).click();

String keyword = request.getParameter("<parameter-inserted-by-user>");
//insert text inside search form
WebElement insert_element = driver.findElement(By.xpath("//input[@class='input-text-input-ManagedTextInput__managedInput--106PS']"));

insert_element.sendKeys(keyword);
Thread.sleep(1000);    //  <-- Not ideal but for a permanent solution, but illustrates this is timing related.
insert_element.sendKeys(Keys.ENTER);