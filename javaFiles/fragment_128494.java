public static void assetManagementFocus(InternetExplorerDriver driver)
{
    WebElement assetManagementFocus = driver.findElement(By.xpath(".//*[text()='Asset Management']"));
    Actions hoverOnReportWindow = new Actions(driver);
    hoverOnReportWindow.moveToElement(assetManagementFocus).build().perform();
    Thread.sleep(3000);
    assetManagementFocus.click();
}