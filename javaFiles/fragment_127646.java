List <WebElement> checkbox = driver.findElements(By.xpath("Your xpath here"));

for(WebElement e:checkbox)
{
if(!e.isSelected){
e.click;
}
}