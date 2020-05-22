public class Website extends SeleneseTestBase {
     @BeforeMethod
     public void setUp() throws Exception {
         selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.washingtonpost.com/");
         selenium.start();
     }

     @Test
     public void testWebsite() throws Exception {
         selenium.open("/");
         waitFor("link=Sign In");
         waitSecomd(3);
         selenium.click("link=Sign In");
         selenium.waitForPageToLoad("60000");
         selenium.type("name=MemberName", "adasf@gmail.com");
         selenium.type("name=Password", "adfasd");
         selenium.click("name=submit");
         selenium.waitForPageToLoad("60000");
     }

     @AfterMethod
     public void tearDown() throws Exception {
         selenium.stop();
     }
     public void waitFor(String locator) throws Exception {
         for (int second = 0;; second++) {
             if (second >= 60)
                 fail("timeout");
             try {
                 if (selenium.isVisible(locator))
                     break;
             } catch (Exception e) {}
             Thread.sleep(1000);
         }
     }


     public void waitSecomd(int n) throws Exception {
         for (int second = 0;; second++) {
             if (second >= 60)
                 fail("timeout");
             try {
                 if (second > n - 1)
                     break;
             } catch (Exception e) {}
             Thread.sleep(1000);
         }
     }
 }