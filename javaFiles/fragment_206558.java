public class TestClass extends classHelper//has BrowserSetup(); and CloseBrowser(); {`

     @Rule
     public ScreenshotTestRule my = new ScreenshotTestRule(); 

     @Before
     public void BeforeTest()
     {
          BrowserSetup();// launches chromedriver browser
     }

     @Test
     public void ViewAssetPage() 
     {
       try
      {
        //My test code here//And want to take screenshot on failure
      }
      catch(Exception e)
      {
          //print e
          takeScreenShot();
      }
     }

     @After
     public void AfterTest() throws InterruptedException
     {
          CloseBrowser();//closes the browser after test passes or fails
     }
    }