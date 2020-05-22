WebDriverWait wait = new WebDriverWait(driver, 20);
Actions actions = new Actions(driver);

int clicks = Integer.valueOf(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("info-wrapper--clicks-text"))).getText());

List<WebElement> charts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".highcharts-series-group rect:not([height='0'])")));

AtomicInteger totalChartClicks = new AtomicInteger();

charts.forEach(webElement -> {
    actions.moveToElement(webElement).perform();
    int amount = Integer.valueOf(driver.findElement(By.cssSelector("div.highcharts-tooltip span:nth-of-type(2)")).getText().replace("Total Clicks ",""));
    totalChartClicks.addAndGet(amount);
});

Assert.assertEquals(totalChartClicks.get(), clicks);