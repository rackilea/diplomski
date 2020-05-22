Boolean bflag = false;

try {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert().accept();
     } catch (NoAlertPresentException e) {
        bflag = true;
    }

if (blag ==true) {//alert is not there}