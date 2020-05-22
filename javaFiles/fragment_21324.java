WebDriver driver = new FirefoxDriver();             
    driver.manage().window().maximize();        

    driver.get("http://preview.harriscountyfws.org/");

    WebElement agencySearchSelect = driver.findElement(
            By.xpath("//div[@id='searchDiv']//span[@aria-owns='ddlRegion_listbox']//span[@class='k-select']"));

    agencySearchSelect.click();

    new WebDriverWait(driver, 3, 100).until(ExpectedConditions.visibilityOfElementLocated(
            By.id("regionSelectPopup")));

    WebElement agencyOption = driver.findElement(
            By.xpath("//div[@id='regionSelectPopup']//label[.='ALL']/preceding-sibling::input[@type='checkbox']"));

    agencyOption.click();