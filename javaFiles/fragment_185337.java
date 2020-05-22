//Mozila Firefox
System.setProperty("webdriver.gecko.driver", "C:\\your_directory\\geckodriver.exe");
WebDriver driver =  new FirefoxDriver();
driver.manage().window().maximize();
driver.get("http:\\gmail.com");
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.id("Email")).sendKeys("your_id");