FirefoxDriver driver = new FirefoxDriver();
driver.get("http://www.google.com");
// display starting tab URL
System.out.println(driver.getCurrentUrl()); // expected output: google.com
WebElement body = driver.findElement(By.cssSelector("body"));
// open new tab
if(System.getProperty("os.name").contains("Mac")) {
    body.sendKeys(Keys.COMMAND + "t");
}
else {
    body.sendKeys(Keys.CONTROL + "t");
}
//navigate in new tab
driver.get("http://www.yahoo.com");
// display new tab URL
System.out.println(driver.getCurrentUrl()); // expected output: yahoo.com
//navigate back to previous tab
body = driver.findElement(By.cssSelector("body"));
body.sendKeys(Keys.CONTROL +""+Keys.SHIFT +""+ Keys.TAB);
// refresh driver view
driver.switchTo().defaultContent();
// display starting tab URL
System.out.println(driver.getCurrentUrl()); // expected output: google.com
driver.close();