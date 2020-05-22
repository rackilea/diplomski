(new WebDriverWait(driver(), 5))
    .until(new ExpectedCondition<WebElement>() {
        public WebElement apply(WebDriver d) {
            return d.findElement(By.linkText(""));
        }
    });