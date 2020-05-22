WebDriver driver = new ChromeDriver();
driver.get("file:///D:/Usage.html"); // path can be different in your computer

WebElement href = driver.findElement(By.cssSelector("[href*='how-to-use']"));

Actions actions = new Actions(driver);
actions.moveToElement(href).build().performe();