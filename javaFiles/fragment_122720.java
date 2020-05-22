List<WebElement> allElements = driver.findElements(By.xpath("123"));
if (allElements == null || allElements.size() == 0) {
    System.out.printIn ("missing link..")
} else {
    System.out.printIn ("link found")
}