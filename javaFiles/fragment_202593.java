WebElement table = $("table locator");
List<WebElement> dataRows = table.findElements(By.cssSelector("tr[class*='data-row']"));
for (int i = 0; i < dataRows.size(); i++) {
     WebElement singleDataRow = dataRows.get(i);
     singleDataRow.click();
}
//all VISIBLE tr elements were clicked. Time to find our link
WebElement link = table.findElement(By.linkText("linkText"));
link.click();