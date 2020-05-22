System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    driver.get("https://accounts.trivago.com/login#");
    String parentWindow = driver.getWindowHandle();     
    System.out.println("Parent Window ID is : " + parentWindow);
    driver.findElement(By.xpath("//button[@class='btn social-login__btn social-login__btn--google btn--reset block js_tlgGoogleSignin']//span[@class='btn__text']")).click();
    WebDriverWait wait = new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    Set<String> s1 = driver.getWindowHandles();
    Iterator<String> i1 = s1.iterator();
    while(i1.hasNext())
    {
        String next_tab = i1.next();
        if (!parentWindow.equalsIgnoreCase(next_tab))
        {
        driver.switchTo().window(next_tab);
        System.out.println("Working on Google Login Box");
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("Divya Master");
        }
    }