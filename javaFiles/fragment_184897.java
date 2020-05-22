public String updateCell(By identifier, int romNumber, int columnNumber, String value) 
{
   WebElement table = driver.findElement(identifier);
   List<WebElement> rows = table.findElements(By.xpath("tbody/tr"));
   List<WebElement> cells = rows.get(romNumber).findElements(By.tagName("td"));
   WebElement desiredCell = cells.get(columnNumber);
   desiredCell.setText(value);
}