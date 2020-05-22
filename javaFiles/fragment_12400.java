public static void selectRJourney(WebDriver driver, String returndate) {
    JavascriptExecutor je=(JavascriptExecutor)driver;
    je.executeScript("document.getElementById('datepicker2').value = '"+returndate+"';");

}
public static void selectJourney(WebDriver driver,String journeydate) {
    JavascriptExecutor je=(JavascriptExecutor)driver;
    je.executeScript("document.getElementById('datepicker1').value = '"+journeydate+"';");

}