List<WebElement> list1 = driver.findElements(By.linkText("Services"));
for(int i=0;i<list1.size();i++)
{
 System.out.println(i+" "+list1.getText());
 //this can be used incase number of elements is more and no time to count there index
}
list1.get(1).click();