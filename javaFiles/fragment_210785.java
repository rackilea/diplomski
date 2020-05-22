public static void main(String[] args) {
    // I don't have Chrome installed >.<
    WebDriver driver = new FirefoxDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get("http://www.google.com");

    WebElement searchBox = driver.findElement(By.id("gbqfq"));
    searchBox.sendKeys("pluralsight");
    searchBox.sendKeys(Keys.RETURN);

    driver.findElement(By.linkText("Images")).click();

    WebElement image = driver.findElement(By.className("rg_di"));
    image.findElements(By.tagName("a")).get(0).click();

    // super-shortened version:
    // driver.findElement(By.className("rg_di")).findElements(By.tagName("a")).get(0).click();
}