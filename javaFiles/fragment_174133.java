@BeforeMethod
    public void Openbrowser() throws MalformedURLException {
   nodeUrl =  "http://172.17.0.3:5555/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.getCurrent());
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
        driver.manage().window().maximize();
         driver.get("https://www.google.com");
    }