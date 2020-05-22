public static Boolean IsObjectExists(WebDriver driver, By locator) {
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        try {
            driver.findElement(locator);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return false;
        }