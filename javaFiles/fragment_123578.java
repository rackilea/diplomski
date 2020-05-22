private void searchGoogleForSelenium() {
    WebDriver driver = new ChromeDriver();
    driver.get(baseURL);
    ((ChromeDriver) driver).findElementById(googleSearchBarLocatorById).sendKeys(searchTerm);
    ((ChromeDriver) driver).findElementById(googleSearchBarLocatorById).sendKeys(Keys.ENTER);
}