System.setProperty("phantomjs.binary.path", "/path/to/phantomjs");
WebDriver driver = new PhantomJSDriver();
// Open your page with SVG
driver.get("http://localhost:8080/svgpage");

// Find the SVG
WebElement svg = driver.findElement(By.tageName("svg"));
// Get its XML content
String xml = svg.getAttribute("outerHTML");