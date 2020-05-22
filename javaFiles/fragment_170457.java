List<WebElement> efirstpagecount = driver.findElements(By.xpath("//*[@id='usersList']/tbody/tr/td[3]"));
Set<String> uniqueUsers = efirstpagecount.stream().map(WebElement::getText).map(String::trim).distinct().collect(Collectors.toSet());   
System.out.println("First page count: "+uniqueUsers.size());

List<WebElement> esecondpagecount = driver.findElements(By.xpath("//*[@id='usersList']/tbody/tr/td[3]"));
Set<String> uniqueUsers2 = esecondpagecount.stream().map(WebElement::getText).map(String::trim).distinct().collect(Collectors.toSet());
uniqueUsers.addAll(uniqueUsers2); // merge two sets
System.out.println("First and second page count: "+uniqueUsers.size());