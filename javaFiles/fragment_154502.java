driver.get("http://www.imdb.com/title/tt2310332/fullcredits?ref_=tt_cl_sm#cast");
String height = "";
String actorName = "";
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
List<WebElement> lstUrls = driver.findElements(By
    .xpath("//span[@itemprop='name']/..")); // all a tags
List<String> urls = new ArrayList<>();
for (WebElement webElement : lstUrls) {
    urls.add(webElement.getAttribute("href")); // saving all hrefs attached in each a tag
}
Map<String, String> actorHeightData = new HashMap<String, String>();
for (String string : urls) {
    driver.get(string);
    actorName = driver.findElement(
        By.xpath(".//*[@id='overview-top']/h1/span")).getText(); // Getting actor's name
    driver.findElement(By.xpath("//a[text()='Biography']")).click(); // Clicking Biography
    try {
        height = driver.findElement(
            By.xpath("//td[.='Height']/following-sibling::td"))
                .getText(); // Getting height
    } catch (NoSuchElementException nsee) {
        height = ""; // If height not found
    }
    actorHeightData.put(actorName, height); // Adding to map
}