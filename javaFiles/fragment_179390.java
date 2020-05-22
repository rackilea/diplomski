String retrieved_text = driver.findElement(By.xpath("//xpath of the element related to records")).getText(); //Retrieving text, i.e., the innerHtml representing number of records

/*Click on the next button to navigate to the next page*/
driver.findElement(By.xpath("//next button's xpath")).click();

WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//xpath of the element related to records"), retrieved_text));