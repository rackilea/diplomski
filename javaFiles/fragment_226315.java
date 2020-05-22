//Set From Date
    driver.findElement(By.id("ctl00_ContentPlaceHolderMain_container_container_Block_172_tabPanelMyAccounts_dtDateFrom_txtDate")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "01/03/2016");
    //Set To date
    driver.findElement(By.id("ctl00_ContentPlaceHolderMain_container_container_Block_172_tabPanelMyAccounts_dtDateTo_txtDate")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "30/04/2016");
    driver.findElement(By.id("ctl00_ContentPlaceHolderMain_container_container_Block_172_tabPanelMyAccounts_btnList")).click();


    List<WebElement> Date =
            driver.findElements(By.xpath(".//*  [@id='ctl00_ContentPlaceHolderMain_container_container_Block_172_tabPanelMyAccounts_stxOutstandingTransactions_gvOSTransactions']/tbody/tr[*]/td[1]"));


    for (int i = 0; i < Date.size(); i++) {
        String date = Date.get(i).getText();
        boolean result = comp_Dates(date);

        if (result) {
            System.out.println(result + ", Address are within the range");
        } else {
            System.out.println(result + ", Addresses are not within the range. Test Case Failed");
        }
    }

private static boolean comp_Dates(String date) {
    try {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        String FromDate = "01/05/2016";
        String ToDate = "30/06/2016";

        java.util.Date Fdate = fmt.parse(FromDate);
        java.util.Date Tdate = fmt.parse(ToDate);
        java.util.Date ActualDate = fmt.parse(date);

        if (ActualDate.compareTo(Fdate) >= 0 && ActualDate.compareTo(Tdate) <= 0) {
            return true;
        }
    } catch (Exception ex) {
        System.out.println(ex);
    }
    return false;
}