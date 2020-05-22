WebDriverWait wait=new WebDriverWait(driver, 30);
    List<WebElement> dropdown =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='txtPageNumber']/option")));

    int rowCount = 0;

    for(int k=1;k<dropdown.size()-1;k++) {
        List<WebElement> newdropdown =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='txtPageNumber']/option")));

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='index']/tbody/tr"));
       // List<WebElement> col = driver.findElements(By.xpath("//table[@class='index']/tbody/tr[1]/th"));

        for(int i=0;i<rows.size()-1;i++){
            WebElement webRow = rows.get(i);
            List<WebElement> col = webRow.findElements(By.tagName("td"));
            XSSFRow row = sheet.createRow(rowCount);
            rowCount++;
            for (int j=0; j<col.size(); j++) {
                WebElement webCell = col.get(j);
                String text = webCell.getText();
                Cell excelCell = row.createCell(j);
                excelCell.setCellValue(webCell.getText());
            }


        }

        newdropdown.get(k).click();

    }