@BeforeTest
public static void driveraBaglan() {
    //Driver is declared here. I removed it to give the simple code. 
    user = driver.findElement(By.id("user"));
    pass = driver.findElement(By.id("pass"));
    login = driver.findElement(By.xpath("//button[contains(.,'Log In')]"));
    statusMessage = driver.findElement(By.id("login-status-message")).getText();

}