public void CreateSalesOrder()
{
    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.pollingEvery(2, TimeUnit.SECONDS);
    wait.until(ExpectedConditions.elementToBeClickable(btnNewSalesOrser));
    btnNewSalesOrser.click();
}