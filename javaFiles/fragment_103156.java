// get the text of the body element
WebElement body = driver.findElement(By.tagName("body"));
String bodyText = body.getText();

// count occurrences of the string
int count = 0;

// search for the String within the text
while (bodyText.contains("VIM LIQUID MARATHI")){

    // when match is found, increment the count
    count++;

    // continue searching from where you left off
    bodyText = bodyText.substring(bodyText.indexOf("VIM LIQUID MARATHI") + "VIM LIQUID MARATHI".length());
}
System.out.println(count);