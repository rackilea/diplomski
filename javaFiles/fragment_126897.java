@Test 
public void testWebTable()  { 
WebElement simpleTable = driver.findElement(By.xpath("//table[@id='txn-display-table']//tbody")); 

    // Get all rows 
    List<WebElement> rows = simpleTable.findElements(By.tagName("tr")); 
    Assert.assertEquals(rows.size(),4); 

    // Print data from each row 
    for (WebElement row : rows) { 
        List<WebElement> cols = row.findElements(By.tagName("td")); 
        for (WebElement col : cols) {
             System.out.print(col.getText() + "\t"); 
           } System.out.println(); 
       }
    }