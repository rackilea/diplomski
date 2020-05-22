System.setProperty("webdriver.chrome.driver", "E:\\sankalp\\my_Selenium\\chromedriver.exe");

//then your code

WebDriver driver= new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("https://q-apis-two.iot-build.qa.covapp.io/#/dashboard");
driver.manage().window().maximize();

driver.findElement(By.id("user")).sendKeys("Q-APIS-TWO_ADMIN");
driver.findElement(By.id("password")).sendKeys("Covisint111");

driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
driver.findElement(By.className("btn btn-lg btn-primary btn-block")).click();


driver.close();