public class IntroductoryPage extends ClassUtility {

private ClassUtility driver;

public IntroductoryPage(ClassUtility driver, ClassUtility logger) {
    this.driver= driver;    
}

@When("^It should go to Account \"([^\"]*)\"")
public void openIntroductoryPage(String region) throws Throwable {
    driver.baseDriver.findElement(By.linkText("link")")).click();   
}