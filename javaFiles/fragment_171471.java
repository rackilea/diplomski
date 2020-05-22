new WebDriverWait(driver, TIMEOUT).until(new Predicate<WebDriver>() {
    public boolean apply(WebDriver driver) {
        return (JavascriptExectutor) driver.executeScript(
                    "arguments[0].onclick == null;", getElement());
    }
});