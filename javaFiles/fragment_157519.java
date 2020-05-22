WebDriver driver = new FirefoxDriver();

// And now use this to visit Google
driver.get("http://www.google.com");

// Find the text input element by its name
WebElement element = driver.findElement(By.name("q"));

if (element.getTagName().equalsIgnoreCase("input") 
        && element.getAttribute("type").equalsIgnoreCase("text")) {
    System.out.println("its a textbox");
}