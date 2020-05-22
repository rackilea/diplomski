JavascriptExecutor js = (JavascriptExecutor) driver;

driver.findElement(sendButton).click();

List<WebElement> elements = waitElements(driver, 5, By.className("button-resultdown"));
if (elements.size() == 0){
    List<WebElement> popUpCloseButtons = driver.findElements(popUpClose);
    System.out.println("Popup Close Buttons size: " + popUpCloseButtons.size());
    if (popUpCloseButtons.size() > 0)
        js.executeScript("arguments[0].click();", popUpCloseButtons.get(popUpCloseButtons.size() - 1));
        //popUpCloseButtons.get(popUpCloseButtons.size() - 1).click();
}