List<WebElement> sectionList=driver.findElements(By.xpath("//div[@id='mid']/div"));
int i=0;
for(WebElement element:sectionList){
    System.out.println("Section "+i+":"+element.getText());
    i++;
}