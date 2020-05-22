Map<String,String> map = new Map<String,String>;

List<WebElement> list = driver.findElements(By.xpath("//*[@class='datatable']/tbody/tr")); 

for(int i=1;i<=list.size();i++){

  String key = driver.findElement(By.xpath("//*[@class='datatable']/tbody/tr["+i+"]/td[1]")).getText();
  String value = driver.findElement(By.xpath("//*[@class='datatable']/tbody/tr["+i+"]/td[2]")).getText(); 

   map.put(key,value);
 }