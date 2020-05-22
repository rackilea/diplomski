@Test
  public void f()throws Exception {
      FileInputStream fi=new FileInputStream("E:\\workspace1\\SeleniumAutomation\\test data\\login.xls");
      Workbook w= Workbook.getWorkbook(fi);
      Sheet s=w.getSheet(0);
      driver.findElement(By.id("Email")).sendKeys(s.getCell(0,1).getContents());
      driver.findElement(By.id("Passwd")).sendKeys(s.getCell(1,0).getContents());
      Thread.sleep(5000);
      driver.findElement(By.cssSelector("input#signIn")).click();
      Thread.sleep(3000);
      }
  @BeforeTest
  public void beforeTest() {
      System.setProperty("webdriver.chrome.driver","\\E:\\lib\\chromedriver.exe");
      driver=new ChromeDriver();
      driver.get("https://accounts.google.com/ServiceLogin?service=mail");
  }