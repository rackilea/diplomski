private URI siteBase;
private static PhantomJSDriverService service;
private WebDriver driver;
protected static DesiredCapabilities dCaps;

@BeforeClass
public static void createAndStartService() throws IOException  {
    service = new PhantomJSDriverService.Builder().usingPhantomJSExecutable(new File("/path/to/phantom/driver"))
            .usingAnyFreePort()
            .build();
    service.start();
}
@AfterClass
public static void stopService() throws IOException  {
    service.stop();
}

@Before
public void setUp() throws Exception {
      siteBase = new URI("http://localhost:8080/");
      dCaps = new DesiredCapabilities();
      dCaps.setJavascriptEnabled(true);
      dCaps.setCapability("takesScreenshot", false);

      driver = new RemoteWebDriver(service.getUrl(),dCaps);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@After
public void tearDown() throws Exception {
    driver.quit();
}