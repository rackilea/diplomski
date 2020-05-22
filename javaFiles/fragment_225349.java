public class WebTable1 {

  public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.get("https://www.w3schools.com/html/html_tables.asp");

    String beforeXpath_Company = "//*[@id='customers']/tbody/tr["; // changed customer to single quote
    String aferXpath_Company = "]/td[1]";  //Company is column 1

    String beforeXpath_Contact = "//*[@id='customers']/tbody/tr[";
    String aferXpath_Contact = "]/td[2]";  // Contact is column 2

    String beforeXpath_Country = "//*[@id='customers']/tbody/tr[";
    String aferXpath_Country = "]/td[3]";  // Country is column 3

    //Find number of rows so that we do not use hard coded values
    List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
    int rows=totalRows.size();


    // Create a workbook and a sheet in it
    Workbook wb = new HSSFWorkbook();
    Sheet sheet1 = wb.createSheet("Sheet1");

    // Create a table header
    Row row = sheet.createRow(0);
    row.createCell(0).setCellValue("Company name");
    row.createCell(1).setCellValue("Contact name");
    row.createCell(2).setCellValue("Country");


    for (int i = 2; i <rows; i++) {  //we start from 2 because  1 is column name
        String actualXpath = beforeXpath_Company + i + aferXpath_Company;
        String companyName = driver.findElement(By.xpath(actualXpath)).getText();

        String actualXpath_Contact = beforeXpath_Contact + i + aferXpath_Contact;
        String contactName = driver.findElement(By.xpath(actualXpath_Contact)).getText();

        String actualXpath_Country = beforeXpath_Country + i + aferXpath_Country;
        String countryName = driver.findElement(By.xpath(actualXpath_Country)).getText();

        Row row = sheet1.createRow(i - 1);
        row.createCell(0).setCellValue(companyName);
        row.createCell(1).setCellValue(contactName);
        row.createCell(2).setCellValue(countryName);
    }
    FileOutputStream fileOut = new FileOutputStream("C:\\MyTemp\\Test.xls");
    wb.write(fileOut);
    fileOut.close();
  }
}