public class InventoryPage extends ClassUtility {
private ClassUtility driver;
public InventoryPage(ClassUtility driver, ClassUtility fileElementLocator, ClassUtility elementLocatorProperties, ClassUtility page) {
    this.driver= driver;
    this.page =page;
}

@When("^Open the Google Page$")
public void openInventoryPage() throws Throwable {  
    driver.baseDriver = new FirefoxDriver();
    driver.baseDriver.get("www.google.com");
}