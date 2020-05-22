WebElement myElement = driver.findElement(By.xpath("//div[@id='msg']"));
String text1 = myElement.findElement(By.xpath("./b")).getAttribute("innerHTML");
String text2 = ((JavascriptExecutor)driver).executeScript('return arguments[0].childNodes[3].textContent;', myElement).toString();
String text3 = ((JavascriptExecutor)driver).executeScript('return arguments[0].childNodes[4].textContent;', myElement).toString();
String text4 = ((JavascriptExecutor)driver).executeScript('return arguments[0].childNodes[5].textContent;', myElement).toString();
String text5 = ((JavascriptExecutor)driver).executeScript('return arguments[0].lastChild.textContent;', myElement).toString();