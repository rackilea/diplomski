driver.get("http://www.google.com");

driver.findElement(By.id("lst-ib")).sendKeys("Java" + Keys.ENTER);

int size = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3/a"))).size();

System.out.println(size + " links");

for (int idx = 0; idx < size; idx++) {
    List<WebElement> links = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3/a")));

    WebElement link = links.get(idx);
    String href = link.getAttribute("href");

    link.click();

    System.out.println(idx + ": " + href + ": " + driver.getTitle());

    driver.navigate().back();
}