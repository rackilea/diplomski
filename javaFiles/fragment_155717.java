List<WebElement> allElements = driver.findElements(By.xpath(".//tr/td[contains(.,'text2')]/following-sibling::td[3]/div"));
 for(WebElement element:allElements)
 {
    String status = element.getAttribute("class");
    System.out.println(status);
}