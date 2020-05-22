// enter the postcode into the field
driver.findElement(By.id("postcode-field")).sendKeys("GL32BN");
// click the magnifying glass icon to initiate the search
driver.findElement(By.cssSelector("button[data-text-original='Submit']")).click();
// wait for the desired element to be clickable (it takes a fraction of a second to open the dropdown and populate it)
new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-premise-id='5127035']")))
        .click();
// click the next button
driver.findElement(By.id("next")).click();