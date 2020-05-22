//Assuming first element from list is visible 
String indexOfVisbleElement = "1";
String xpath = "(.//table//td[@class = 'button' and b = 'Refresh'])[" +indexOfVisbleElement+ "]";

//Now find only visible element 
WebElement visibleEl = driver.findElement(By.xpath(xpath));