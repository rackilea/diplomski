//get the table
WebElement table = driver.findElement(By.xpath("Give the xpath of the table"));

//Get all the rows of the table
List rows = table.findElements(By.tagName("tr"));

//Iterate through the rows
for(WebElement row: rows) {
    //Get the columns in the row
    Webelement columns = row.findElements(By.tagName("td"));
    //Iterate through each column in the row
    for (WebElements column: columns) {
        //Check if the column contains the required text
        if (column.getText().equals("Google")) {
            //Print the id of the row that contains the column with text 'Google'
            System.out.println(row.getAttribute("id");)
            break;
        }
    }

}