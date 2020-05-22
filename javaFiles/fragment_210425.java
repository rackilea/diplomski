WebDriver driver = new ChromeDriver();
driver.get(url);

// sometimes here we might also need to wait for the page to load

System.out.println(driver.getPageSource());