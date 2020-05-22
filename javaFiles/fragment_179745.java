public class Test1 extends Setup{
      @Test
      public void facebook() {
          System.out.println("Inside Facebook");
      }

      @BeforeClass
      public void beforeClass() {
          driver = new FirefoxDriver();
          driver.get("https://www.facebook.com/");
      }

      @AfterClass
      public void afterClass() {
            driver.close();
      }
   }