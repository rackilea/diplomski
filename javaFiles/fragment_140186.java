@Test
public void departmentsDropMusic1() throws Exception {

    System.setProperty("webdriver.gecko.driver", "C:\\Projects\\SeleniumDrivers\\geckodriver.exe");

    driver = new FirefoxDriver();

    driver.get("https://www.amazon.com");
    Thread.sleep(5000L);

    openSubMenu("Amazon Music");

    openSubMenu("Fire TV");

}