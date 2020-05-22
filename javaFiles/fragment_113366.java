try {
    WebDriverWait wait = new WebDriverWait(driver, 8);
    wait.until(ExpectedConditions.alertIsPresent());
    Alert alert = driver.switchTo().alert();
    alert.accept();
} catch (Exception e) {
    //handle the exception
}