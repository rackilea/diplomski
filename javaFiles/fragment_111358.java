WebDriver driver;

    private List <WebElement>coupon;
    private List <WebElement> airName;
    private String url="https://www.cleartrip.com/";
    public CleartripPOM1(WebDriver driver) {
        this.driver=driver;
        coupon=driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/td/span"));
        airName=driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/th/small"));
        -----------
        ----------- and so on

    }