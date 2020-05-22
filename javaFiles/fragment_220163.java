By byXpath = By.xpath("//a[.='" + user_id + "']");

WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(byXpath));
String newUser  = myDynamicElement.getText().trim();

//send newUser this to the search field