List <WebElement> checkbox = driver.findElements(By.xpath("Your xpath here"));

for(WebElement e:checkbox)
{
if(e.getAttribute("value").equals("1")){
e.click;
}
}