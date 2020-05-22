for(int i=0; i<rows.size(); i++) {
    //check column each in row, identification with 'td' tag
    List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

    //column iteration
    for(int j=0; j<cols.size(); j++) {
        System.out.println("row " +(i+1) +" col " +(j+1) +" : " +cols.get(j).getText());
    }
}