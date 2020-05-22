public class url{ 
        public static void main(String[] args) throws Exception {

            // TODO Auto-generated method stub
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.google.co.in/");
            driver.manage().window().maximize(); 
            driver.findElement(By.name("q")).sendKeys("selenium");
           driver.findElement(By.xpath("//*[@id='sblsbb']/button")).click();
           List<WebElement> elements = driver.findElements(By.tagName("a"));
            System.out.println(elements.size());
            String url=driver.getCurrentUrl(); 

            URL aURL = new URL(url);

 System.out.println("protocol = " + aURL.getProtocol());
 System.out.println("authority = " + aURL.getAuthority());
 System.out.println("host = " + aURL.getHost());
 System.out.println("port = " + aURL.getPort());
 System.out.println("path = " + aURL.getPath());
 System.out.println("query = " + aURL.getQuery());
 System.out.println("filename = " + aURL.getFile());
 System.out.println("ref = " + aURL.getRef());  


        }
}