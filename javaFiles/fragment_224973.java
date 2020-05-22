@Test
public void login(){
    WebDriver driver = new FirefoxDriver();
    driver.get("https://stackoverflow.com/");
    driver.findElement(By.cssSelector(".login-link.btn-clear")).click();
}