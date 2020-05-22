import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

driver.get("https://www.goibibo.com/");
WebDriverWait wait = new WebDriverWait(driver, 10);

wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign In"))).click();

//switch to popup iframe to enter login credentials into form
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("authiframe"));

//now enter login credentials   
driver.findElement(By.id("id_username")).sendKeys("username");
driver.findElement(By.id("id_password")).sendKeys("password");

//now click on sign in button
driver.findElement(By.id("signinBtn")).click();