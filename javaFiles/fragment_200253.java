public void waitUntilRowPopulates(WebElement element, final int rowCount) {
        final WebElement table = element;

        new FluentWait<WebDriver>(driver)
        .withTimeout(60, TimeUnit.SECONDS)
        .pollingEvery(10, TimeUnit.MILLISECONDS)
        .until(new Predicate<WebDriver>() {

            public boolean apply(WebDriver d) {
                 List<WebElement> rawList = table.findElements(By.tagName("tr"));
                 return (rawList.size() >= rowCount);
            }
        });
    }