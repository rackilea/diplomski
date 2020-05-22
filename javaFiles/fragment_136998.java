private static void waitTillAllVisible(WebDriverWait wait, By locator) {

    wait.until(new ExpectedCondition<Boolean>() {

        @Override
        public Boolean apply(WebDriver driver) {

            Iterator<WebElement> eleIterator = driver.findElements(locator).iterator();
            while (eleIterator.hasNext()) {
                boolean displayed = false;
                try {
                    displayed = eleIterator.next().isDisplayed();
                }
                catch (NoSuchElementException | StaleElementReferenceException e) {
                    // 'No such element' or 'Stale' means element is not available on the page
                    displayed = false;
                }
                if (displayed) {
                    // return false even if one of them is displayed.
                    return false;
                }
            }
            // this means all are not displayed/invisible
            return true;
        }
    });
}