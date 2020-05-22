WebDriver driver;
@Before
public void browser(){
 System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CP-SAT\\Chromedriver\\chromedriver.exe"); 
 driver = new ChromeDriver(); 
}

@Test
public void verifyHomePageTitle() {     

    String BaseURL = "http://newtours.demoaut.com/";
    driver.get(BaseURL);
    String ExpectedTitle = "Welcome: Mercury Tours";
    String ActualTitle = driver.getTitle();
    Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

@Test
public void a() {
    driver.get("https://www.google.co.in/?gfe_rd=cr&ei=6PDbV-qTAZHT8gecr4qQBA");    
} 

@After
public void close(){
    driver.quit();
    }
}