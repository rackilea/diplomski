ArrayList<String> obtainedList = new ArrayList<>(); 
List<WebElement> elementList= driver.findElements(By.xpath(YourLocator));
for(webElement we:elementList){
   obtainedList.add(we.getText);
}
ArrayList<String> sortedList = new ArrayList<>();   
for(String s:obtainedList){
sortedList.add(s);
}
Collections.sort(sortedList);
Assert.assertTrue(sortedList.equals(obtainedList));