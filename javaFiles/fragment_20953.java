//DiamTest class
@BeforeClass
    public static void setUpClass() {
        //Here we initialize the firefox webdriver
        driver=new FirefoxDriver();
        driver.get(url);
    }