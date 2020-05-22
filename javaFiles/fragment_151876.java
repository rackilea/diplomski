WebElement mainelem = url.findElement(By.tagName("main"));
List<WebElement> piclinks = mainelem.findElements(By.xpath(".//a[starts-with(@href, '/p/')]"));

for (WebElement picLink : piclinks) {
    //... picLink processing...
}