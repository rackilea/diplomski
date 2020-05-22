WebDriver driver = new FirefoxDriver();

    String xpath = "html/body/div[2]/div/ul/li";

    driver.get("http://www.timeanddate.com/worldclock/");
    int i=1;
    List<WebElement> elements = driver.findElements(By.xpath(xpath));

    for(int i = 0; i < elements.size(); ++i) {
        System.out.println("current column value is"+i);    

    }

    System.out.println("total colored columns are "+elements.size());