public class pageLoadTimeout 
{
    public static void main(String[] args) 
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        try{
          driver.get("https://www.booking.com/hotel/in/the-taj-mahal-palace-tower.html?label=gen173nr-1FCAEoggJCAlhYSDNiBW5vcmVmaGyIAQGYATG4AQbIAQzYAQHoAQH4AQKSAgF5qAID;sid=338ad58d8e83c71e6aa78c67a2996616;dest_id=-2092174;dest_type=city;dist=0;group_adults=2;hip_dst=1;hpos=1;room1=A%2CA;sb_price_type=total;srfid=ccd41231d2f37b82d695970f081412152a59586aX1;srpvid=c71751e539ea01ce;type=total;ucfs=1&#hotelTmpl");
          // do your other work here
        }catch(WebDriverException e){
          System.out.println("WebDriverException occured");
          }
        driver.quit();
    }
}