Set<String> handles = driver.getWindowHandles(); 
Iterator<String> windows = handles.iterator(); 
String parent = windows.next(); 
String child = windows.next();
driver.switchTo().window(child);
driver.findElement(By.xpath("insert xpath to OK button")).click();
driver.switchTo().window(parent);
//continue with steps on parent window