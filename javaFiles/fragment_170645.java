driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 30);
try {
    driver.get("http://");
} catch (TimeoutException e) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title")));
}