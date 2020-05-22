Wait<WebDriver> wait = new FluentWait<>(driver)
    .withTimeout(60, TimeUnit.SECONDS)
    .pollingEvery(5, TimeUnit.SECONDS)
    .ignoring(NoSuchElementException.class);

wait.until(new Function<WebDriver, Boolean>() {
  @Override
  public Boolean apply(WebDriver driver) {
    return driver.findElement(By.cssSelector("my-css-selector")).getText().contains("name");
  }
});