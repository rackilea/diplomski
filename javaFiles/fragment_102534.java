for (String url : urls) {
    driver.get(url);
    //adjust to your needs: long timeOutInSeconds, long sleepInMillis
    WebDriverWait wait = new WebDriverWait(driver, 120L, 1000L);
    try {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        //TODO: Element found within timeOutInSeconds
    } catch (WebDriverException e) {
        //TODO: Element not present after timeOutInSeconds, write url to txt file
    }
}