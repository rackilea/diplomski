int i = 0;
while (i <= 2) {
    WebDriver driver = new ChromeDriver();

    // Start timer
    StopWatch pageLoad = new StopWatch();
    pageLoad.start();
    // Go to URL & skip basic auth
    driver.get("https://www.godaddy.com/");

    // Wait for cookies to be displayed or 10 seconds then

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Cookies")));
    pageLoad.stop();

    // Get the time
    long pageLoadTime_ms = pageLoad.getTime();
    long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
    driver.close();

    try {
        HSSFWorkbook workbook;
        Sheet sheet;

        if(i==0) {
             workbook = new HSSFWorkbook();
            sheet = workbook.createSheet("Page Load Times");

        }
        else {
            FileInputStream fis = new FileInputStream("/Users/mackro/Desktop/Java Workspace/Data Tables/" + date1 + ".xls");
            workbook = new HSSFWorkbook(fis);
            sheet = workbook.getSheet("Page Load Times");

        }

        Row row = sheet.createRow(i);
        Cell cell = row.createCell(0);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(pageLoadTime_ms);

        FileOutputStream fos = new FileOutputStream("/Users/mackro/Desktop/Java Workspace/Data Tables/" + date1 + ".xls");
        workbook.write(fos);
        fos.flush();
        fos.close();
        workbook.close();
        } catch (FileNotFoundException fnfe) {

        fnfe.printStackTrace();

    } catch (IOException ioe) {

        ioe.printStackTrace();

    }

        i++;
    }