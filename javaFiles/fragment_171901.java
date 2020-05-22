/* ... */
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/home/kasptom/selenium/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("file:///home/kasptom/Dev/stack-java-maven/src/main/resources/my_page.html");

    List<WebElement> lis = driver.findElements(By.tagName("li"));

    List<WebElement> lisWithNoStyle = lis.stream()
            .filter(SeleniumLiDemo::isStyleAttributePresent)
            .collect(Collectors.toList());

    System.out.format("Number of <li> detected %d, with no style %d%n", lis.size(), lisWithNoStyle.size());
}

private static boolean isStyleAttributePresent(WebElement element) {
    String attributeValue = element.getAttribute("style");
    return attributeValue != null && attributeValue.isEmpty();
}
/* ... */