public static void main(String args[]) throws InterruptedException, AWTException, IOException, DocumentException {

    System.setProperty("webdriver.chrome.driver", "/home/OtherProj/webDrivers/chromedriver_64");

    String downloadPath = "/home/Downloads/AAAA/";
    File file = new File(downloadPath);
    if(!file.exists())
        file.mkdirs();

    ChromeOptions chromeOptions = new ChromeOptions();

    HashMap<String, Object> prefs = new HashMap<>();        
    prefs.put("plugins.always_open_pdf_externally", true);

    chromeOptions.addArguments("--test-type");
    chromeOptions.addArguments("--disable-extensions");
    chromeOptions.setExperimentalOption("prefs", prefs);
    chromeOptions.setHeadless(true);

    String pdfUrl = "https://www.dummyurl.com/prod/displayImageDocs.php?f=MjAxODsafdfgsdjhgsjkA3MjQxMDUwNzA4Ni5QREY=&p=aW1hZ2UuaW1hZ2ViYW5rLmJhbmsxLjIwMTgwNy4yMDE4MDcyNA==&a=MTAwMsgsdjM0&POL_NUM=AAS06036999";

    ChromeDriverService driverService = ChromeDriverService.createDefaultService();
    WebDriver driver = new ChromeDriver(driverService, chromeOptions);

    // Saves the file on the given path
    PDFDemo.downloadFile(downloadPath, driverService, driver, pdfUrl);      
    System.out.println("Document Downloaded..");
}

private static void downloadFile(String downloadPath, ChromeDriverService driverService, WebDriver driver, String pdfUrl) throws ClientProtocolException, IOException, InterruptedException {

    Map<String, Object> commandParams = new HashMap<>();
    commandParams.put("cmd", "Page.setDownloadBehavior");
    Map<String, String> params = new HashMap<>();
    params.put("behavior", "allow");
    params.put("downloadPath", downloadPath);
    commandParams.put("params", params);
    HttpClient httpClient = HttpClientBuilder.create().build();

    ObjectMapper objectMapper = new ObjectMapper();
    String command = objectMapper.writeValueAsString(commandParams);        
    String u = driverService.getUrl().toString() + "/session/" + ((RemoteWebDriver) driver).getSessionId() + "/chromium/send_command";
    HttpPost request = new HttpPost(u);
    request.addHeader("content-type", "application/pdf");
    request.setEntity(new StringEntity(command));
    httpClient.execute(request);

    // Opens pdf of specific URL
    driver.get(pdfUrl);
}