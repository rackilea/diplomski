public class Countrychoser {
    WebDriver driver;

    @BeforeTest
    public void startTest(){
        driver = Baseurl.basic();
    } 

    @Test
    public void Choser() {
        try {
            //driver.findElement(By.className("box_countryChooser")).click();
            driver.findElement(By.id("intselect")).sendKeys("India");
            driver.findElement(By.xpath(".//*[@id='countryChooser']/a/img")).click();
            //window.onbeforeunload = null;
            System.out.println("---------------------------------------");
            System.out.println("Country choser layer test case-Success");
            System.out.println("---------------------------------------");
        } catch(Exception e) {
            // Screenshot.pageScreenshot();
            System.out.println(e);
            System.out.println("---------------------------------------");
            System.out.println("Country choser layer test case Failed");
            System.out.println("---------------------------------------");
        }
    }

    @AfterTest
    public void endTest() {  
        // Screenshot.pageScreenshot(); 
        // Baseurl.Closebrowser();
    }
}