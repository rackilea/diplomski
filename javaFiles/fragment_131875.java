Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(10, TimeUnit.SECONDS)
        .pollingEvery(1, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);

WebElement el = wait.until(new Function<WebDriver, WebElement>() {
    public WebElement apply(WebDriver driver) {
        return driver.findElement(By.id("skip_btn"));
    }
});

el.click();