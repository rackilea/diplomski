WebElement table = $("table locator");
List<WebElement> dataRows = table.findElements(By.cssSelector("tr[class*='actions']"));
for (int i = 0; i < dataRows.size(); i++) {
    WebElement singleDataRow = dataRows.get(i);
    singleDataRow.click();
}
//all HIDDEN tr elements were clicked. Time to find our link
WebElement link = table.findElement(By.linkText("linkText"));
link.click();