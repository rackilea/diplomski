// Get all the table row elements from the table 
List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='branded-fares-flights']//tr")); 

// And iterate over them and get all the cells 
for (WebElement row : allRows) { 
    List<WebElement> cells = row.findElements(By.tagName("td")); 

    // Print the contents of each cell
    for (WebElement cell : cells) {         

    System.out.println(cell.getText());
    //Or try below code 
    //System.out.println(cell.getAttribute("innerHTML"));
}