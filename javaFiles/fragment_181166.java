WebElement myElement = driver.findElement(By.xpath("//span[@class='control-label' and @id='MainContent']"));
// to extract the text "Text 1"
String myText1 = ((JavascriptExecutor)driver).executeScript('return arguments[0].firstChild.textContent;', myElement).toString();
// to extract the text "Text 2"
String myText2 = ((JavascriptExecutor)driver).executeScript('return arguments[0].childNodes[3].textContent;', myElement).toString();
// to extract the text "Text 3"
String myText3 = ((JavascriptExecutor)driver).executeScript('return arguments[0].lastChild.textContent;', myElement).toString();