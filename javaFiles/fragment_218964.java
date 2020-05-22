static WebDriver driver=null;
public static void main(String[] args) {
final FirefoxProfile firefoxProfile = new FirefoxProfile();
firefoxProfile.setPreference("xpinstall.signatures.required", false);
driver = new FirefoxDriver(firefoxProfile);
driver.get("https://www.google.de/");