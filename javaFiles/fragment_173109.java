public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://amazon.in");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement search = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));

        //Search using actions by combining entering search string and then hit enter
        action.click(search).sendKeys("Test").sendKeys(Keys.RETURN).build().perform();

        // This also works where it does the same without actions class
        search.sendKeys("test");
        search.sendKeys(Keys.RETURN);
    }