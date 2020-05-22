System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.get(url);
new WebDriverWait(driver, 20).until(
        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
String source = driver.getPageSource();
driver.close();

ConverterProperties properties = new ConverterProperties().setBaseUri(url);
HtmlConverter.convertToPdf(source, new PdfWriter("result.pdf"), properties);