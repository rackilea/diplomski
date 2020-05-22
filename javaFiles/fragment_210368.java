WebDriver driver = new AnyDriverYouWant();
if (driver instanceof JavascriptExecutor) {
    ((JavascriptExecutor)driver).executeScript("yourScript();");
} else {
    throw new IllegalStateException("This driver does not support JavaScript!");
}