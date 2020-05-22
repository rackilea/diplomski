public boolean retryingFindClick(By by) {
    boolean result = false;
    int attempts = 0;
    while(attempts < 2) {
        try {
            driver.findElement(by).click();
            result = true;
            break;
        } catch(StaleElementException e) {
        }
        attempts++;
    }
    return result;
}