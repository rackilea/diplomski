// before changing of window we saved the 
// String parentHandle = driver.getWindowHandle();

WebElement FbLoginFacebook = (new WebDriverWait(driver, 20)).until(
    ExpectedConditions.presenceOfElementLocated(By.id("login_form"))
);
FbLoginFacebook.submit();

driver.switchTo().window(parentHandle);