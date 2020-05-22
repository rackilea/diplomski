Set<String> allUsers = new HashSet();
while(true){
  List<WebElement> users = driver.findElements(By.xpath("xpath"));
  allUsers.addAll(users.stream().map(WebElement::getText).map(String::trim).distinct().collect(Collectors.toSet()));
  // move to next page if exists, else break loop
}
System.out.println("All pages count: " + allUsers.size());