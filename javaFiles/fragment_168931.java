public boolean isElementPresent(WebDriver driver, By elem) {
        try {
            driver.findElement(elem);
            return true;
        }catch(NoSuchElementException e) {
            return false;
        }
    }