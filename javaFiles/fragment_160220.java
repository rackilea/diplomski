WebDriver driver = new FirefoxDriver();
driver.get("http://www.htmlcodetutorial.com/forms/_SELECT_MULTIPLE.html");
List<WebElement> options = driver.findElements(By.xpath("//select[@name='toppings']//option"));

// Values to select
List<String> values =  Arrays.asList("onions", "olives");

// Select all the options
Actions act = new Actions(driver);
act.keyDown(Keys.CONTROL);
for (WebElement option: options){
    if(values.contains(option.getText())) {
        act.click(option);
    }
}
act.keyUp(Keys.CONTROL);
act.perform();

driver.quit();