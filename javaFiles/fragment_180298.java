public class enterValidCredentials {
  public void run(WebDriver driver) {
    driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("XXXXXX");
    driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("XXXXXX");    
  }
}