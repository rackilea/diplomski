WebDriver driver; // No need to initialize to null, it's the default

public Actions action; // Don't initialize here

public EnglishHomepage (WebDriver driver) {
    this.driver = driver; 
    this.action = new Actions(driver);
}