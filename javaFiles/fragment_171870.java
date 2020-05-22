String margin= "";
for(int i=1;i<=2;i++)
{ 
  WebElement points = driver.findElement(By.id("id["+i+"]")); 
  margin += points.getCssValues("margin-bottom"); 
} 
System.out.println(margin); // this would print both margin into single