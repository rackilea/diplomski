System.setProperty("webdriver.chrome.driver", "C:\\Users\\Faruk\\IdeaProjects\\Dailymotion\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://en.savefrom.net");

    WebElement textField = driver.findElement(By.id("sf_url"));
    textField.sendKeys("https://www.dailymotion.com/video/x737y37");

    WebElement button = driver.findElement(By.id("sf_submit"));
    button.click();

    try {
        TimeUnit.SECONDS.sleep(15);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    driver.findElement(By.linkText("Download")).click();