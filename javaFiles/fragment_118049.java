driver.get("https://www.premierleague.com/tables");

    WebElement table;

    WebDriverWait wait = new WebDriverWait(driver, 30);
    table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[3]/div/div")));
    String dataoutput;
    dataoutput = table.getText();
    System.out.println(dataoutput);

    String csvOutputFile = "table.csv";

    try(FileWriter writecsv = new FileWriter("src/main/table.csv")) {
        writecsv.append(dataoutput);
    }