public class Dubai {
     public static void main(String[] args) throws InterruptedException {
            try {

                   public static void main(String[] args) throws Exception {
    System.setProperty ("webdriver.chrome.driver",
                       "C:\\Users\\miyau\\Desktop\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  WebDriverWait wait=new WebDriverWait(driver,50 );

                  driver.manage().window().maximize();
                  Thread.sleep(500);

                  driver.get("http://www.thomascook.in/");
                  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                   driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='__st_preview_frame_bpn']")));
                  System.out.println(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/span")).getText());

                  driver.findElement(By.id("__st_bpn_no")).click();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
}