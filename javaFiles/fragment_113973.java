//try 1 
String selectedText = driver.findElement(By.cssSelector("li.x-boundlist-selected")).getText();
System.out.println(selectedText)

//try 2
selectedText = driver.findElement(By.cssSelector("li.x-boundlist-selected")).getAttribute("textContent");
System.out.println(selectedText)