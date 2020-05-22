// Do stuff to get to the page needed for the test
driver.findElement(By.id("saveHouseholdMember"))
      .click();
// Make sure the panel first appears and then disappears
By panelBy = By.xpath("/html/body/div[2]/form[1]/div/table/tbody/tr/td/span");
new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(panelBy));
new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(panelBy));
// Panel is gone, click the next button
driver.findElement(By.id("disabilityFlagRadio"))
      .click();