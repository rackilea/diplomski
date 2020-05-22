protected RemoteWebDriver driver;
@Test
public void testing() throws FileNotFoundException, IOException {
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    driver = new RemoteWebDriver(new URL("http://google.com"),capability);
    System.out.println();
}