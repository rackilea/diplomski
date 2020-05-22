WebElement autoCompelet = driver.findElement(By.xpath("//ul[@class='af_list']"));
List<WebElement> options = autoCompelet.findElements(By.tagName("li"));
logger.debug(options.size());
for (WebElement option1 : options) {
    logger.debug(option1);
}