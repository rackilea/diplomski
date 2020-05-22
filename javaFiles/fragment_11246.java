WebDriver driver = new FirefoxDriver();
    driver.get("https://play.google.com/store/apps/details?id=com.facebook.orca");

    WebElement permission = driver.findElement(By.className("id-view-permissions-details"));
    permission.click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement modalPopup = driver.findElement(By.className("modal-dialog"));
    wait.until(ExpectedConditions.visibilityOf(modalPopup));

    String xpath = "//ul[@class='bucket-description']//li[text()='precise location (GPS and network-based)']";
    WebElement whatTheHeck = driver.findElement(By.xpath(xpath));
    System.out.println(whatTheHeck.getText());

    driver.quit();