public static void main(final String[] args) {
    System.out.println("Running Tests....");
    // Optional, if not specified, WebDriver will search your path for
    // chromedriver.
    System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
    final WebDriver driver = new ChromeDriver();
    driver.get("http://preview.harriscountyfws.org/");
    driver.manage().window().maximize();
    WebElement we;
    String searchText;
    WebElement dropdown;
    // if you comment out the next two lines after these comments and
    // uncomment out the commented lines below, the code works
    searchText = "110:A100_110 Clear Creek @ I-45";
    dropdown = driver.findElement(By.cssSelector("span[aria-owns='ddlGage_listbox']"));
    // searchText = "24 Hours";
    // dropdown =
    // driver.findElements(By.cssSelector("span.k-widget")).get(1);
    System.out.println("Attempting Dropdown Click....");
    dropdown.click();
    System.out.println("Finished running Dropdown Click....");
    Sleep(4);
    // Select dd2 = new Select(driver.findElement(By.id("ddlTimeSpan")));
    // dd2.selectByVisibleText(searchText);
    we = driver.findElement(By.xpath("//li[text()='" + searchText + "']"));
    if (we != null) {
        we.click();
    }
    System.out.println("Finished Selecting Dropdown....");
    // driver.quit();
}