List<WebElement> results = driver.findElements(By.xpath("XPATH HERE"));   
//Get the Total Count
System.out.println(results.size());
if(results.size() ==100)
{
    System.out.println("100 REsults are found as Expected");
}

//To display the http value for each results
for(WebElement each : results)
{
    System.out.println(each.getAttribute("href"));
}