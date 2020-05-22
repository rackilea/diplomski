// Find the span tag which contains text (at) and (dot) and get the text
Sting textInElement = driver.findElement(By.xpath("//span[contains(.,'(at)')][contains(.,'(dot)')]")).getText();

// Split the String based on space
String[] textRequired  = textInElement.split(" ");

// Iterate through array to print the array component containing (dot)  and (at) 
for (int i=0; i<string.length; i++) {
    if (string[i].contains("(at)")&&string[i].contains("(dot)"))
        System.out.println(string[i]);
}