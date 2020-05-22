// get the print button
WebElement print_button = driver.findElement(By.cssSelector("..."));

// click on the print button and wait for print to be called
driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
((JavascriptExecutor)driver).executeAsyncScript(
    "var callback = arguments[1];" +
    "window.print = function(){callback();};" +
    "arguments[0].click();"
    , print_button);