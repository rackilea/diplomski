static WebDriver driver=null;
    public static void main(String[] args) {
         driver = new FirefoxDriver();
         driver.get("URL");
         String dataID = driver.findElement(By.xpath("//input[@id='chkAuction4c42556772376a443736343d']/@data-id")).gettext();
         System.out.println(dataID);
}