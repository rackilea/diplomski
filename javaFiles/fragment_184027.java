public static ExpectedCondition<WebElement> textInValue(final WebElement el) {
    return new ExpectedCondition<WebElement>() {
        @Override
        public WebElement apply(WebDriver driver) {
            return el.getAttribute("value").equals("") ? el : null;
        }
    }
}