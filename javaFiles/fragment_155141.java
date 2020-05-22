final Select droplist = new Select(driver.findElement(By.Id("selection")));
new FluentWait<WebDriver>(driver)
        .withTimeout(60, TimeUnit.SECONDS)
        .pollingEvery(10, TimeUnit.MILLISECONDS)
        .until(new Predicate<WebDriver>() {

            public boolean apply(WebDriver d) {
                return (!droplist.getOptions().isEmpty());
            }
        });