private void searchGoogleForSelenium() {
    WebDriver driver = new ChromeDriver();
    driver.get(baseURL);
    driver.findElementById(googleSearchBarLocatorById).sendKeys(searchTerm);
    driver.findElementById(googleSearchBarLocatorById).sendKeys(Keys.ENTER);
}