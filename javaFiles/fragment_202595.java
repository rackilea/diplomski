WebElement table = $("table locator");
List<WebElement> dataRows = table.findElements(By.cssSelector("tr[class*='data-row']"));
for (int i = 0; i < dataRows.size(); i++) {
     WebElement singleDataRow = dataRows.get(i);
     singleDataRow.click();

     //we need to find the link after clicking each `tr` element.
     try {
         WebElement link = table.findElement(By.linkText("linkText"));
         link.click();
         break;
     } catch (NoSuchElementException e) {
         //ignore the exception. It means our link does not exist in this row and we need to continue the iteration
     }
}