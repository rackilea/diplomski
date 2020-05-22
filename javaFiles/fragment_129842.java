Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
       .withTimeout(30, SECONDS)
       .pollingEvery(1, SECONDS)
       .ignoring(NoSuchElementException.class);

   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.id("foo"));
     }
   });