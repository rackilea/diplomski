List<WebElement> sectionList=driver.findElements(By.xpath("//div[@id='mid']/div"));
int i=0;
//Inorder to get the Section 3 Content
int section=2;
for(WebElement element:sectionList){
    if(section==i){
        System.out.println("Section "+i+":"+element.getText());
    }
    i++;
}