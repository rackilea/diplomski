WebDriver driver = new FirefoxDriver();
driver.get("http://www.example.com");

List<WebElement> elements = driver.findElements(By.cssSelector("table.team-list tr"));

for(WebElement element: elements)
{
    System.out.println(element.getAttribute('data-code'));
}