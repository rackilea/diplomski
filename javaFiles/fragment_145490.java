public class Driver implements WebDriver {

   private WebDriver webDriver;
   private Capabilities caps;

   public Driver(){
      System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "the/driver/path/chromedriver.exe");
      caps = DesiredCapabilities.chrome();
      webDriver = new ChromeDriver(caps);

      //Cast webDriver instance to RemoteWebDriver
      caps = ((RemoteWebDriver) webDriver).getCapabilities();

      //Call getCapability and cast to Map. 
      //This line will give a Type Safety warning, hence the "dirty" in my solution.
      Map<String, String> a = (Map<String, String>) caps.getCapability("chrome");
      System.out.println(String.format("Driver Version: %s", a.get("chromedriverVersion")));
      System.out.println(String.format("Temp dir: %s", a.get("userDataDir")));
   }
}