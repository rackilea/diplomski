private static Function<WebDriver,WebElement> presenceOfElementLocated(final By locator) {
    return new Function<WebDriver, WebElement>() {
        @Override
        public WebElement apply(WebDriver driver) {
            return driver.findElement(locator);
        }
    };
}