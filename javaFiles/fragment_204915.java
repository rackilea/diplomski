List<WebElement> allElements = driver.findElements(By.xpath("//ul[@id='t1-travListing']/li"));
int i=0;
allElements.remove(allElements.size()-1); // not sure why are you doing this
for (WebElement element: allElements) {
    System.out.println(element.findElements(By.xpath("./a")).getText());        
}