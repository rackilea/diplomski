boolean isElementPresent(By by) {
    try {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(by);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return true;
    }
    catch(Exception e){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return false;
    }
}