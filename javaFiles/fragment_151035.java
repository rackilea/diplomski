String locator = "tbody > tr[data-ng-repeat='member in searchresult'] > td.sorting_1";

List<WebElement> tds = driver.findElements(By.cssSelector(locator));

ArrayList<String> memberNums = new ArrayList<String>()

for(WebElement ele : tds) {
  memberNums.add(ele.getText());
}