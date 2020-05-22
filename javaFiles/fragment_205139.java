java.util.List<WebElement> els =
    driver.findElements(By.xpath("//input[@type='checkbox']"));

JavascriptExecutor jse = (JavascriptExecutor) driver;

for (WebElement el : els) {
  jse.executeScript("arguments[0].click()", el);
}