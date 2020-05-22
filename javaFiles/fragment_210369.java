WebDriver driver = new AnyDriverYouWant();
JavascriptExecutor js;
if (driver instanceof JavascriptExecutor) {
    js = (JavascriptExecutor)driver;
} // else throw...

// later on...
js.executeScript("return document.getElementById('someId');");