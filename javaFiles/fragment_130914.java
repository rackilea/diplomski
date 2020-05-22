WebDriver driver = new FirefoxDriver();
    driver.get("https://www.upwork.com/o/jobs/browse/");
    List<WebElement> titles = driver.findElements(By.xpath("//h2/a"));
    for (int i=0; i<titles.size(); i++) {
        //TODO add a code to wait until first page loaded

        //To handle StaleElementReferenceException
        WebElement title = driver.findElements(By.xpath("//h2/a")).get(i);
        System.out.println("text: " + title.getAttribute("innerText"));
        System.out.println("tag: " + title.getTagName());
        title.click();
        driver.navigate().back();
    }